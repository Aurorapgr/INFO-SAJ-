package com.infosaj.saj60

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.infosaj.saj60.databinding.ActivitySaudeBinding

class saude : AppCompatActivity() {
    private lateinit var binding : ActivitySaudeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaudeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}