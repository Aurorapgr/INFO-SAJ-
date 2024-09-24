package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infosaj.saj60.databinding.ActivitySaudeBinding

class Saude : AppCompatActivity() {
    private lateinit var binding : ActivitySaudeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySaudeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toSUS.setOnClickListener {
            startActivity(Intent(this,Sus::class.java))
        }
        binding.toInstOngs.setOnClickListener {
            startActivity(Intent(this,InstOngs::class.java))
        }
        binding.toServUFRB.setOnClickListener {
            startActivity(Intent(this,ServUFRB::class.java))
        }

    }
}