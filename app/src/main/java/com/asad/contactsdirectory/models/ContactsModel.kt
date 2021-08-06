package com.asad.contactsdirectory.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.asad.contactsdirectory.data.local.db.converters.PhoneTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "contacts")
@TypeConverters(PhoneTypeConverter::class)
data class ContactsModel(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: Phone
)