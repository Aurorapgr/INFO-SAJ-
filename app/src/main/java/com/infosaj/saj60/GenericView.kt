package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.infosaj.saj60.data.NavData
import com.infosaj.saj60.data.NavInfo
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

        val iL : List<List<Intent>> = listOf(
            listOf(
                Intent(this,Sus::class.java),
                Intent(this,GenericView::class.java),
                Intent(this,ServUFRB::class.java),
                Intent(this,UsfStandard::class.java)
            ),
            listOf(),
            listOf(),
            listOf(),

        )



        val indexID = intent.getIntExtra("ID",0)
        val aa = indexID.toString()


        putItens(NavData.Nav1[indexID],indexID,iL)
        Toast.makeText(this,aa,Toast.LENGTH_SHORT).show()





        setContentView(view)
    }

    override fun onResume() {
        super.onResume()
        val a = intent.getIntExtra("ID",0)

        Toast.makeText(this,a.toString(), Toast.LENGTH_SHORT).show()
    }


    fun putItens(item: NavInfo, indexID : Int, listIntent: List<List<Intent>>){
        val nextIntent = Intent(this,GenericView::class.java)

        binding.title.text = item.title
        //adasdasdasdsd

        val infoList = item.tabInfo
        nextIntent.putExtra("ID",item.id)


        infoList.forEachIndexed{ i,e ->
            val btn = btnSections(this,e)
            btn.setOnClickListener{


                listIntent[indexID][i].putExtra("USFINDEX",22)
                startActivity(listIntent[indexID][i])
            }
            binding.linearLayout.addView(btn)

        }
    }
}


