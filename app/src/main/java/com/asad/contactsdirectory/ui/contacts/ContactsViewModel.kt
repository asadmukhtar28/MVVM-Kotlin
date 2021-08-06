package com.asad.contactsdirectory.ui.contacts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.asad.contactsdirectory.models.ContactsModel
import com.asad.contactsdirectory.models.base.State
import com.asad.contactsdirectory.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(var contactsRepository: ContactsRepository) :
    BaseViewModel<ContactsNavigator>(contactsRepository.dataManager) {
    val contactList = MutableLiveData<List<ContactsModel>>()

    fun fetchFromDbClick() {
        viewModelScope.launch {
            contactsRepository.fetchContactsFromDb().run {
                if (this != null) {
                    if (this.isNotEmpty()) {
                        contactList.value = this
                    }
                }
            }
        }
    }

    fun fetchFromServerClick() {
        viewModelScope.launch {
            makeApiCall()
            saveRecordsToDb()
        }
    }

    private suspend fun makeApiCall() {
        withContext(viewModelScope.coroutineContext) {
            getNavigator()?.showProgressBar()
            when (val request = contactsRepository.fetchContacts()) {
                is State.Success -> {
                    getNavigator()?.hideProgressBar()
                    request.wrapperData.data?.let {
                        if (it.isNotEmpty()) {
                            Log.d("asad_async_call", "api call response")
                            contactList.value = it
                        } else {
                            getNavigator()?.showSuccessMessage("No Contacts Found")
                        }
                    }
                }
                is State.Error -> {
                    getNavigator()?.hideProgressBar()
                }
            }
        }
    }

    private fun saveRecordsToDb() {
        contactList.value?.let {
            if (it.isNotEmpty()) {
                viewModelScope.launch(Dispatchers.IO) {
                    dataManager.getDbHelper().deleteAllContacts()
                    dataManager.getDbHelper().insertContacts(it)
                    Log.d("asad_async_call", "Insert Successfully")
                }
            }
        }
    }
}