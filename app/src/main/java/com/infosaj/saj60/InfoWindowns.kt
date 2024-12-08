package com.infosaj.saj60

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

        setContentView(binding.root)

    }
}