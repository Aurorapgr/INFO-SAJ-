package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.infosaj.saj60.data.GlobalData
import com.infosaj.saj60.data.NavElements
import com.infosaj.saj60.data.NavInfo
import com.infosaj.saj60.data.Tela
import com.infosaj.saj60.databinding.ActivityGenericViewBinding

class GenericView : AppCompatActivity() {
    private lateinit var binding : ActivityGenericViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenericViewBinding.inflate(layoutInflater)

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

        setBtns(NavElements.telas[GlobalData.rPT])






        setContentView(view)
    }

    fun setBtns(nE : Tela ) {
        binding.title.text = nE.title

        nE.btns.forEachIndexed { i, e ->
            val btn = btnSections(this, e.title, i)

            btn.setOnClickListener {
                if(e.refpt != null){
                    GlobalData.rPT = e.refpt
                    startActivity(Intent(this,GenericView::class.java))
                }
                if (e.refpt == null){
                    GlobalData.dataObject = e.dObj!!
                    GlobalData.dO_GlobalIndex = e.index!!
                    startActivity(Intent(this,e.act))

                }
            }

            binding.linearLayout.addView(btn)
        }
    }

    override fun onResume() {
        super.onResume()

    }



}


