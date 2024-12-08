package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.infosaj.saj60.databinding.ActivityServUfrbBinding

class ServUFRB : AppCompatActivity() {
    private lateinit var binding : ActivityServUfrbBinding
    private val buttonList = mutableListOf<AppCompatButton>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = ActivityServUfrbBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val home = binding.home
        val back = binding.back
        home.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        back.setOnClickListener{
            finish()
        }


        val nextIntent = Intent(this, UsfStandard::class.java)
        val btnList = listOf(
            binding.LABCOV,
            binding.servPSI
        )

        findAllAppComnpatButtons(view,buttonList)




        btnList.forEachIndexed {i, e ->
            e.setOnClickListener {
                nextIntent.putExtra("UFRBINDEX",i)
                startActivity(nextIntent)
            }
        }


    }
    fun findAllAppComnpatButtons(viewGroup: ViewGroup, btnList : MutableList<AppCompatButton>) {
        for (i in 0 until viewGroup.childCount) {
            val view = viewGroup.getChildAt(i)

            if (view is AppCompatButton) {
                btnList.add(view)
            } else if (view is ViewGroup) {
                findAllAppComnpatButtons(view,btnList)
            }
        }
    }
}