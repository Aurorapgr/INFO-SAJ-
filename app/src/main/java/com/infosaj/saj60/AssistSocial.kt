package com.infosaj.saj60

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.infosaj.saj60.databinding.ActivityAssistSocialBinding

class AssistSocial : AppCompatActivity() {
    private lateinit var binding : ActivityAssistSocialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityAssistSocialBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}