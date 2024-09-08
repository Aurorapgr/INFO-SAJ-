package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infosaj.saj60.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        binding.tohealth.setOnClickListener {
            startActivity(Intent(this,saude::class.java))
        }
        binding.toass.setOnClickListener {
            startActivity(Intent(this, AssistSocial::class.java))
        }
        binding.tolazerEduca.setOnClickListener {
            startActivity(Intent(this, LazerEduca::class.java))
        }
        binding.todireitosSeguran.setOnClickListener {
            startActivity(Intent(this, DireitosSeguran::class.java))
        }

    }
}