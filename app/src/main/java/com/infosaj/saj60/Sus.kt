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

        binding = ActivitySusBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toUSFs.setOnClickListener {

            startActivity(Intent(this, Usfs::class.java))
        }

        binding.toUNACON.setOnClickListener {
            Toast.makeText(this,"AAAAAAAAAA",Toast.LENGTH_LONG).show()
            startActivity(Intent(this, Unacon::class.java))
        }
    }
}