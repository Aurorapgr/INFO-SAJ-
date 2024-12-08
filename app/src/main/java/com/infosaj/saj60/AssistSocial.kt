package com.infosaj.saj60

import android.content.Intent
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
        val nextIntent = Intent(this, UsfStandard::class.java)
        setContentView(view)

        val home = binding.home
        val back = binding.back
        home.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        back.setOnClickListener{
            finish()
        }

        binding.CRAS.setOnClickListener {
            nextIntent.putExtra("ASINDEX",0)
            startActivity(nextIntent)
        }
        binding.CREAS.setOnClickListener {
            nextIntent.putExtra("ASINDEX",1)
            startActivity(nextIntent)
        }
        binding.ESCONV.setOnClickListener {
            nextIntent.putExtra("ASINDEX",2)
            startActivity(nextIntent)
        }

    }
}