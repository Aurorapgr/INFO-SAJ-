package com.infosaj.saj60

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.infosaj.saj60.databinding.ActivityUsfStandardBinding

class UsfStandard : AppCompatActivity() {
    private lateinit var binding : ActivityUsfStandardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUsfStandardBinding.inflate(layoutInflater)
        val view = binding.root
        val db = Data.usfs
        builder(db,0)



        setContentView(view)





    }
    private fun builder(obj: List<UsfContructor>,i: Int){
        val serv = obj[i].serv
        val addr = obj[i].addr
        val phone = obj[i].phone
        val usfName = obj[i].usfName
        
        var atd = SpannableString("Atendimento $serv")
        var edr = SpannableString("Endereço $addr")
        var tlf = SpannableString("Telefone $phone")
        var bolder = StyleSpan(Typeface.BOLD)

        atd.setSpan(bolder,0,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        edr.setSpan(bolder,0,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tlf.setSpan(bolder,0,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.title.text = usfName
        binding.service.text = atd
        binding.address.text = edr
        binding.phone.text = tlf
    }



}