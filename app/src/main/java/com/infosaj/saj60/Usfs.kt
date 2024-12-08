package com.infosaj.saj60

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import android.util.Log
import com.infosaj.saj60.databinding.ActivityUsfsBinding

class Usfs : AppCompatActivity() {
    private lateinit var binding : ActivityUsfsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = ActivityUsfsBinding.inflate(layoutInflater)
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
            binding.usfAlMo,
            binding.usfASA,
            binding.usfASIeII,
            binding.usfAnd,
            binding.usfAmp,
            binding.usfAPDR,
            binding.usfBID,
            binding.usfBV,
            binding.usfBVB,
            binding.usfCF,
            binding.usfCNII,
            binding.usfCUI,
            binding.usfFQ,
            binding.usfGPSII,
            binding.usfMA,
            binding.usfPCMS,
            binding.usfSFIeII,
            binding.usfSP,
            binding.usfSM,
            binding.usfUIII,
            binding.usfVL,
            binding.usfZA
        )


        btnList.forEachIndexed {i, e ->
            e.setOnClickListener {
                nextIntent.putExtra("USFINDEX",i)
                startActivity(nextIntent)
            }
        }

    }
}





