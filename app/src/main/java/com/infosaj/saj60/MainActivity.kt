package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.infosaj.saj60.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        val nextIntent = Intent(this, GenericView::class.java)
        val btnList : List<AppCompatButton> = listOf(
            binding.toSaude,
            binding.toAssistSocial,
            binding.toLazerEduca,
            binding.toDireitosSeguran
        )

        btnList.forEachIndexed { index, e ->
            e.setOnClickListener {
                nextIntent.putExtra("ID",index)
                startActivity(nextIntent)
            }
        }










        binding.emerg.setOnClickListener {
            startActivity(Intent(this, Emergen::class.java))
        }
        binding.infotab.setOnClickListener {
            startActivity(Intent(this, InfoWindowns::class.java))
        }

        setContentView(view)
    }
}