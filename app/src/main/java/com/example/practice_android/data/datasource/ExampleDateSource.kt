package com.example.practice_android.data.datasource

import com.example.practice_android.data.service.ExampleService
import com.example.practice_android.data.model.request.ExampleRequestDto
import com.example.practice_android.data.model.response.ExampleResponseDto
import com.example.practice_android.data.model.response.wrapper.BaseResponse

class ExampleDateSource(
    private val exampleService: ExampleService
) {
    suspend fun postExample(exampleRequestDto: ExampleRequestDto): BaseResponse<ExampleResponseDto> =
        exampleService.postExample(exampleRequestDto)
}