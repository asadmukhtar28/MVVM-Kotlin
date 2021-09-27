package com.asad.contactsdirectory.ui.contacts

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.asad.contactsdirectory.models.ContactsModel
import com.asad.contactsdirectory.models.base.State
import com.asad.contactsdirectory.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(var contactsRepository: ContactsRepository) :
    BaseViewModel<ContactsNavigator>(contactsRepository.dataManager) {
    val contactList = MutableLiveData<List<ContactsModel>>()
    val observableArrayList = ObservableArrayList<ContactsModel>()

    fun fetchFromDbClick() {
        if (observableArrayList.size > 0)
            observableArrayList.clear()

        viewModelScope.launch {
            contactsRepository.fetchContactsFromDb().run {
                /*
                * Add a small delay to reflect the changes on the UI
                */
                delay(5)
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
        if (observableArrayList.size > 0)
            observableArrayList.clear()

        withContext(viewModelScope.coroutineContext) {
            getNavigator()?.showProgressBar()
            when (val request = contactsRepository.fetchContacts()) {
                is State.Success -> {
                    getNavigator()?.hideProgressBar()
                    request.wrapperData.data?.let {
                        if (it.isNotEmpty()) {
                            contactList.value = it
                        } else {
                            getNavigator()?.showSuccessMessage("No Contacts Found")
                        }
                    }
                }
                is State.Error -> {
                    getNavigator()?.showErrorMessage(request.responseError.errorMessage)
                    getNavigator()?.hideProgressBar()

                    resetData()
                }
            }
        }
    }

    private fun resetData() {
        /*
        * Function to reset data back to View in case Api call fails
        */
        contactList.value?.let {
            if (it.isNotEmpty()) {
                observableArrayList.addAll(it)
            }
        }
    }

    private fun saveRecordsToDb() {
        contactList.value?.let {
            if (it.isNotEmpty()) {
                viewModelScope.launch(Dispatchers.IO) {
                    dataManager.getDbHelper().deleteAllContacts()
                    dataManager.getDbHelper().insertContacts(it)
                }
            }
        }
    }
}