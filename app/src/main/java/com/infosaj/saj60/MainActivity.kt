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

        binding.toSaude.setOnClickListener {
            startActivity(Intent(this, UsfStandard::class.java))
        }
        binding.toAssistSocial.setOnClickListener {
            startActivity(Intent(this, AssistSocial::class.java))
        }
        binding.toLazerEduca.setOnClickListener {
            startActivity(Intent(this, LazerEduca::class.java))
        }
        binding.toDireitosSeguran.setOnClickListener {
            startActivity(Intent(this, DireitosSeguran::class.java))
        }

    }
}