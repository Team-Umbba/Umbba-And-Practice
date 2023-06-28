package com.example.practice_android.domain.repository

import com.example.practice_android.data.model.request.ExampleRequestDto
import com.example.practice_android.data.model.response.ExampleResponseDto
import com.example.practice_android.data.model.response.wrapper.BaseResponse

interface ExampleRepository {
    suspend fun postExample(exampleRequestDto: ExampleRequestDto): Result<BaseResponse<ExampleResponseDto>>
}