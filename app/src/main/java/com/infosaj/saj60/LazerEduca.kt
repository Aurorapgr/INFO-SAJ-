package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infosaj.saj60.databinding.ActivityLazerEducaBinding

class LazerEduca : AppCompatActivity() {
    private lateinit var binding : ActivityLazerEducaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLazerEducaBinding.inflate(layoutInflater)
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
        val btnList = listOf(
            binding.UATI,
            binding.VOSA,
            binding.SECEDU
        )


        btnList.forEachIndexed {i, e ->
            e.setOnClickListener {
                nextIntent.putExtra("LEINDEX",i)
                startActivity(nextIntent)
            }
        }
    }
}