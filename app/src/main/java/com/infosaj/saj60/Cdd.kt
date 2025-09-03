package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import com.infosaj.saj60.databinding.ActivityCddBinding

class Cdd : AppCompatActivity() {
    private lateinit var readScreen: ReadScreen

    private lateinit var binding: ActivityCddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCddBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.VMP.setOnClickListener {
            toComplaint(0)
        }
        binding.VCM.setOnClickListener {
            toComplaint(1)
        }

        binding.home.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        binding.back.setOnClickListener{
            finish()
        }

        val listBtns = binding.linearLayout.children.filterIsInstance<TextView>().toList()
        val armengue1 =  listBtns.filterIndexed {  i, _ -> i != 0 }
        readScreen = ReadScreen(this,armengue1,binding.play)


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


    private fun toComplaint(i: Int){

        val complaintIntent = Intent(this@Cdd, Complaint::class.java)

        complaintIntent.putExtra("COMPINDEX", i)
        startActivity(complaintIntent)

    }
}