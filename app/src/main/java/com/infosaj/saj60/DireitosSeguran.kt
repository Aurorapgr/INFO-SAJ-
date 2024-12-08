package com.infosaj.saj60

import android.content.Intent
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

        val home = binding.home
        val back = binding.back
        home.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        back.setOnClickListener{
            finish()
        }

        binding.CDD.setOnClickListener {
            startActivity(Intent(this,Cdd::class.java))
        }


        val nextIntent = Intent(this,UsfStandard::class.java)
        val btnList = listOf(
            binding.DPT,
            binding.MINPUB,
            binding.CONMUN,
            binding.DELEG,
            binding.EMPRECONSIG,
            binding.BENF
        )

        setContentView(view)

        btnList.forEachIndexed {i, e ->
            e.setOnClickListener {
                nextIntent.putExtra("DSINDEX",i)
                startActivity(nextIntent)
            }
        }
    }
}