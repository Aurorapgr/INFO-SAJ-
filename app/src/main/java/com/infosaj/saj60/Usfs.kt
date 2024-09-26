package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import android.util.Log
import com.infosaj.saj60.databinding.ActivityUsfsBinding

class Usfs : AppCompatActivity() {
    private lateinit var binding : ActivityUsfsBinding
    private val buttonList = mutableListOf<AppCompatButton>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityUsfsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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
                nextIntent.putExtra("INDEX",i)
                startActivity(nextIntent)
            }
        }



        findAllAppComnpatButtons(view)
    }
    fun findAllAppComnpatButtons(viewGroup: ViewGroup) {
        for (i in 0 until viewGroup.childCount) {
            val view = viewGroup.getChildAt(i)

            if (view is AppCompatButton) {
                buttonList.add(view)
                Log.d("Oi", "AppCompatButton encontrado: ID = ${view.id}, Texto = ${view.text}")
            } else if (view is ViewGroup) {
                findAllAppComnpatButtons(view)
            }
        }
    }
}
