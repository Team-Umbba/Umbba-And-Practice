package com.example.practice_android.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class ExampleRequestDto(
    val id: String,
    val pw: String
)
