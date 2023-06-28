package com.example.practice_android.data.model.response.wrapper

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val status: Int,
    val message: String,
    val data: T?
)
