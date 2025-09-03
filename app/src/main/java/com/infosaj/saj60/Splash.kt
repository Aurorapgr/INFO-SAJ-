package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.children
import com.infosaj.saj60.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var readScreen: ReadScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)


        binding.entendi.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


        setContentView(binding.root)


        val listBtns = binding.root.children.filterIsInstance<TextView>().toList()
        readScreen = ReadScreen(this,listBtns,binding.play)

        binding.play.setOnClickListener {
            if (!readScreen.isReading) {
                readScreen.startReadBtns()
            } else {
                readScreen.stopReadBtns()
            }
        }


    }
}