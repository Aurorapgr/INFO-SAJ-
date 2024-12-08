package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.infosaj.saj60.databinding.ActivityCddBinding

class Cdd : AppCompatActivity() {
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




    }

    private fun toComplaint(i: Int){

        val complaintIntent = Intent(this@Cdd, Complaint::class.java)

        complaintIntent.putExtra("COMPINDEX", i)
        startActivity(complaintIntent)

    }
}