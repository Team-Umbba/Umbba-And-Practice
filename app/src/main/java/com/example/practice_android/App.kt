package com.example.practice_android

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.example.practice_android.BuildConfig.KAKAO_NATIVE_APP_KEY

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, KAKAO_NATIVE_APP_KEY)
    }
}