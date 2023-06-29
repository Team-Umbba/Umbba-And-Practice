package com.example.practice_android

import android.os.Bundle
import com.example.practice_android.databinding.ActivitySecondBinding
import com.example.practice_android.util.binding.BindingActivity

class SecondActivity : BindingActivity<ActivitySecondBinding>(R.layout.activity_second) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}