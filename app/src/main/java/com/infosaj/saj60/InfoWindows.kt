package com.infosaj.saj60

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infosaj.saj60.data.InfoTab
import com.infosaj.saj60.databinding.ActivityInfoWindownsBinding

class InfoWindowns : AppCompatActivity() {
    private lateinit var binding: ActivityInfoWindownsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoWindownsBinding.inflate(layoutInflater)

        binding.info2.text = InfoTab.info.info2


        val url = "https://www.aurorasdj.com.br/PDPInfoSAJ60+.html"
        val intentURL =Intent(Intent.ACTION_VIEW, Uri.parse(url))

        binding.PDP.setOnClickListener {
            startActivity(intentURL)
        }
        binding.back.setOnClickListener {
            finish()
        }
        binding.home.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }



        setContentView(binding.root)

    }
}