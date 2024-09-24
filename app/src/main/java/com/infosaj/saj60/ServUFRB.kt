package com.infosaj.saj60

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.infosaj.saj60.databinding.ActivityServUfrbBinding

class ServUFRB : AppCompatActivity() {
    private lateinit var binding : ActivityServUfrbBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServUfrbBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}