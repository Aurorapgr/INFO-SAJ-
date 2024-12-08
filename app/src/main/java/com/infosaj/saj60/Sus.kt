package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.infosaj.saj60.databinding.ActivitySusBinding

class Sus : AppCompatActivity() {
    private lateinit var binding: ActivitySusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nextIntent = Intent(this, UsfStandard::class.java)
        binding = ActivitySusBinding.inflate(layoutInflater)
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

        binding.toUSFs.setOnClickListener {
            startActivity(Intent(this,Usfs::class.java))

        }


        val btnList = listOf(
            binding.PCRE,
            binding.HRSAJ,
            binding.PCMU,
            binding.UNACON
        )


        btnList.forEachIndexed {i, e ->
            e.setOnClickListener {
                nextIntent.putExtra("SUSINDEX",i)
                startActivity(nextIntent)
            }
        }


    }
}