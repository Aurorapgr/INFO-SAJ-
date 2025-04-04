package com.infosaj.saj60

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.core.view.marginBottom
import com.infosaj.saj60.data.EPC
import com.infosaj.saj60.data.EPhones
import com.infosaj.saj60.databinding.ActivityEmergenBinding
import org.w3c.dom.Text

class Emergen : AppCompatActivity() {
    private lateinit var binding : ActivityEmergenBinding
    private lateinit var readScreen: ReadScreen
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


        binding.linearLayout.apply {
            showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
            dividerDrawable = ColorDrawable(Color.TRANSPARENT)
            dividerPadding = 80
        }

        val listBtns = binding.linearLayout.children.filterIsInstance<TextView>().toList()
        val armengue1 =  listBtns.filterIndexed {  i, _ ->  i != 5 && i != 0 }




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



    private fun setterItensHealth(){
        val epData = EPhones.epData

        binding.linearLayout.addView(genericTitle(this,"SAÚDE"))
        binding.linearLayout.addView(genericView(this))

        epData.forEachIndexed{i,e ->
            setterItemH(e,i)
        }

    }
    private fun setterItensSeg(){
        val epsData = EPhones.epSData

        binding.linearLayout.addView(genericTitle(this,"SEGURANÇA"))
        binding.linearLayout.addView(genericView(this))

        epsData.forEachIndexed{i,e ->
            setterItemS(e,i)
        }

    }
    private fun setterItemS(obj: EPC, i:Int){

        var title = obj.title
        var btn1 = btnEmerg("",obj.phone1)
        var btn2 = btnEmerg("",obj.phone2)

        binding.linearLayout.addView(genericTV(this,title))
        binding.linearLayout.addView(btn1)
        binding.linearLayout.addView(btn2)
        binding.linearLayout.addView(genericView(this))

    }


    private fun setterItemH(obj: EPC, i:Int){
        var btn = btnEmerg(obj.title,obj.phone1)
        binding.linearLayout.addView(btn)
        binding.linearLayout.addView(genericView(this))


    }
}