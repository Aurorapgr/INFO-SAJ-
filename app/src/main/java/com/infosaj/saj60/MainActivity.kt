package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infosaj.saj60.data.GlobalData
import com.infosaj.saj60.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var readScreen: ReadScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view =binding.root
        val nextIntent = Intent(this, GenericView::class.java)

        val listBtns = listOf(
            binding.toSaude,
            binding.toAssistSocial,
            binding.toLazerEduca,
            binding.toDireitosSeguran,
            binding.emerg
        )

        readScreen = ReadScreen(this,listBtns,binding.play)


        binding.toSaude.setOnClickListener {
            GlobalData.rPT = 0
            startActivity(nextIntent)
        }
        binding.toAssistSocial.setOnClickListener {
            GlobalData.rPT = 5
            startActivity(nextIntent)
        }
        binding.toLazerEduca.setOnClickListener {
            GlobalData.rPT = 6
            startActivity(nextIntent)
        }
        binding.toDireitosSeguran.setOnClickListener {
            GlobalData.rPT = 7
            startActivity(nextIntent)
        }


        binding.emerg.setOnClickListener {
            startActivity(Intent(this, Emergen::class.java))
        }
        binding.infotab.setOnClickListener {
            startActivity(Intent(this, InfoWindows::class.java))
        }

        setContentView(view)




        binding.play.setOnClickListener {
            if (!readScreen.isReading) {
                readScreen.startReadBtns()
            } else {
                readScreen.stopReadBtns()
            }
        }


    }



    override fun onStop() {
        super.onStop()
        readScreen.stopReadBtns()

    }



}