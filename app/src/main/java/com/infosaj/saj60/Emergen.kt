package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.infosaj.saj60.data.EPC
import com.infosaj.saj60.data.EPhones
import com.infosaj.saj60.databinding.ActivityEmergenBinding

class Emergen : AppCompatActivity() {
    private lateinit var binding : ActivityEmergenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityEmergenBinding.inflate(layoutInflater)

        window.statusBarColor = ContextCompat.getColor(this, R.color.purple)

        val view = binding.root


        val home = binding.home
        val back = binding.back
        home.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        back.setOnClickListener{
            finish()
        }

        setterItensHealth()
        setterItensSeg()



        setContentView(view)



    }
    private fun setterItensSeg(){
        val epData = EPhones.epSData
        binding.linearLayout.addView(genericTitle(this,"SEGURANÇA"))
        binding.linearLayout.addView(genericView(this))
        epData.forEachIndexed{i,e ->
            setterItem1(e,i)
        }
    }

    private fun setterItensHealth(){
        val epData = EPhones.epData
        binding.linearLayout.addView(genericTitle(this,"SAÚDE"))
        binding.linearLayout.addView(genericView(this))
        epData.forEachIndexed{i,e ->
            setterItem0(e,i)
        }

    }

    private fun setterItem1(obj: EPC, i: Int){
        val newBtn = btnEmerg(obj.title,obj.phone1)
        newBtn.addView(btnEmerg2(obj.phone2))
        binding.linearLayout.addView(newBtn)
        binding.linearLayout.addView(genericView(this))

    }


    private fun setterItem0(obj: EPC, i:Int){

        binding.linearLayout.addView(btnEmerg(obj.title,obj.phone1))
        binding.linearLayout.addView(genericView(this))

    }
}