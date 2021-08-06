package com.asad.contactsdirectory.models.base

import com.google.gson.annotations.SerializedName

class ResponsePacket<T> {
    @SerializedName("data")
    var data: T? = null

    @SerializedName("status_code")
    var statusCode: Int = -1

    @SerializedName("error")
    var error: String? = null
}