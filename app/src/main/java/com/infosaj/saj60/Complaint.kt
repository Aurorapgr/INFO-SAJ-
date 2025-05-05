package com.infosaj.saj60

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.core.view.updateLayoutParams
import com.infosaj.saj60.data.CompliantConstructor
import com.infosaj.saj60.data.DirSegData
import com.infosaj.saj60.databinding.ActivityComplaintBinding

class Complaint : AppCompatActivity() {
    private lateinit var readScreen: ReadScreen
    private lateinit var binding: ActivityComplaintBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComplaintBinding.inflate(layoutInflater)
        val view = binding.root




        val extraUS = intent.getIntExtra("COMPINDEX", 999)


        window.statusBarColor = ContextCompat.getColor(this, R.color.purple)





        setContentView(view)

        setterItem(DirSegData.complaint, extraUS)

        binding.home.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        binding.back.setOnClickListener{
            finish()
        }

        val listBtns = binding.linearLayout.children.filterIsInstance<TextView>().toList()
        readScreen = ReadScreen(this,listBtns,binding.play)

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

    private fun setterItem(obj: List<CompliantConstructor>, index: Int) {
        val mutableList = mutableListOf<String>()
        val lista = listOf(
            obj[index].info0,
            obj[index].info1,
            obj[index].info2
        )

        lista.forEachIndexed { i, e ->
            if (e.isNotEmpty()) {
                mutableList.add(e)
            }
        }


        infoBuilder(mutableList, obj, index)
        if (index == 0) {

            binding.linearLayout.addView(createImageView(this,R.drawable.comp_img),5)
            binding.linearLayout.addView(btnLinks(obj[index].info3))
            binding.linearLayout.addView(btnLinks(obj[index].info4))
        }

    }

    private fun infoBuilder(mList: MutableList<String>, obj: List<CompliantConstructor>, i: Int) {
        mList.forEachIndexed { i, e ->
            binding.linearLayout.addView(infoItem(i, e))
        }
        val firstChild = binding.linearLayout.getChildAt(3)
        firstChild.background = ContextCompat.getDrawable(this@Complaint, R.drawable.bg_white_top)
        val lastChild = binding.linearLayout.getChildAt(binding.linearLayout.childCount - 1)
        lastChild.background = ContextCompat.getDrawable(this@Complaint, R.drawable.bg_white_bot)

        binding.title.text = obj[i].title
    }

    private fun infoItem(i: Int, e: String): TextView {
        val pddItem = resources.getDimensionPixelSize(R.dimen.paddingUsfItem)
        val newTextView = TextView(this).apply {
            id = 100 + i
            text = bolder(e)
            textSize = 25f
            minHeight = resources.getDimensionPixelSize(R.dimen.minHeight)
            background =
                ContextCompat.getDrawable(this@Complaint, R.drawable.bg_white_mid)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setPadding(pddItem, pddItem, pddItem, pddItem)
        }

        return newTextView
    }

    private fun btnLinks(link: String): AppCompatButton {
        val intent = Intent(Intent.ACTION_VIEW)
        val pddItem = resources.getDimensionPixelSize(R.dimen.paddingUsfItem)
        val btn = AppCompatButton(this).apply {
            id = 0
            text = "Ir para\n:" + "$link"
            textSize = 18f
            minHeight = resources.getDimensionPixelSize(R.dimen.minHeight)
            textAlignment = View.TEXT_ALIGNMENT_TEXT_START
            background =
                ContextCompat.getDrawable(this@Complaint, R.drawable.btn_white)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = 70

            }

            setPadding(pddItem, pddItem, pddItem, pddItem)
        }
        btn.setOnClickListener {
            intent.data = Uri.parse(link)
            startActivity(intent)
        }

        return btn
    }

    private fun bolder(text: String): SpannableString {
        val bolderText = SpannableString(text)
        if (text.isNotEmpty()) {
            val firstSpaceIndex = text.indexOf(' ')
            if (firstSpaceIndex != -1) {
                bolderText.setSpan(
                    StyleSpan(Typeface.BOLD),
                    0,
                    firstSpaceIndex,
                    0
                )
            }
        }
        return bolderText
    }
}