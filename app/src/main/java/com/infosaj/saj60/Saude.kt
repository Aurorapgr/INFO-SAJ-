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

        val home = binding.home
        val back = binding.back
        home.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        back.setOnClickListener{
            finish()
        }

        val nextIntent = Intent(this, UsfStandard::class.java)


        binding.toSUS.setOnClickListener {
            startActivity(Intent(this,Sus::class.java))
        }
        binding.toInstOngs.setOnClickListener {
            startActivity(Intent(this,InstOngs::class.java))
        }
        binding.toServUFRB.setOnClickListener {
            startActivity(Intent(this,ServUFRB::class.java))
        }

        binding.DP.setOnClickListener{
            nextIntent.putExtra("USFINDEX",22)
            startActivity(nextIntent)
        }




    }
}