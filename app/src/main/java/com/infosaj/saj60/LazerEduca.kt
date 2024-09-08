package com.infosaj.saj60

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infosaj.saj60.databinding.ActivityLazerEducaBinding

class LazerEduca : AppCompatActivity() {
    private lateinit var binding : ActivityLazerEducaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLazerEducaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}