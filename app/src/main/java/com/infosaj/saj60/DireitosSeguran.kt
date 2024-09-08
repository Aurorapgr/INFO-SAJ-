package com.infosaj.saj60

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.infosaj.saj60.databinding.ActivityDireitosSeguranBinding

class DireitosSeguran : AppCompatActivity() {
    private lateinit var binding : ActivityDireitosSeguranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDireitosSeguranBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}