package com.infosaj.saj60

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.infosaj.saj60.databinding.ActivityUsfStandardBinding

class UsfStandard : AppCompatActivity() {
    private lateinit var binding : ActivityUsfStandardBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        window.statusBarColor = ContextCompat.getColor(this,R.color.purple)

        super.onCreate(savedInstanceState)

        binding = ActivityUsfStandardBinding.inflate(layoutInflater)
        val view = binding.root


        val db = Data.usfs




        setContentView(view)
        val extra : Int= intent.getIntExtra("INDEX",0)
        builder(db,extra)
        Toast.makeText(this,"$extra",Toast.LENGTH_SHORT).show()



    }
    private fun builder(obj: List<UsfContructor>,i: Int){
        val aten = obj[i].aten
        val addr = obj[i].addr
        val phone = obj[i].phone
        val usfName = obj[i].usfName
        val img = obj[i].img
        
        var atd = SpannableString("Atendimento: $aten")
        var edr = SpannableString("Endereço: $addr")
        var tlf = SpannableString("Telefone: $phone")
        var bolder = StyleSpan(Typeface.BOLD)

        atd.setSpan(bolder,0,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        edr.setSpan(bolder,0,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tlf.setSpan(bolder,0,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.title.text = usfName
        binding.imgMain.setImageResource(img)
        binding.service.text = atd
        binding.address.text = edr
        binding.phone.text = tlf
    }



}