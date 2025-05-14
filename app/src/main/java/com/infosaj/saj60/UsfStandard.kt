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
import com.infosaj.saj60.data.DirSegData
import com.infosaj.saj60.data.LazerEducData
import com.infosaj.saj60.data.InfoDataConstructor
import com.infosaj.saj60.data.Data
import com.infosaj.saj60.data.GlobalData
import com.infosaj.saj60.databinding.ActivityUsfStandardBinding
import com.infosaj.saj60.databinding.CallPhoneBinding

class UsfStandard : AppCompatActivity() {
    private lateinit var binding: ActivityUsfStandardBinding
    private lateinit var readScreen: ReadScreen

    override fun onCreate(savedInstanceState: Bundle?) {

        window.statusBarColor = ContextCompat.getColor(this, R.color.purple)

        super.onCreate(savedInstanceState)

        binding = ActivityUsfStandardBinding.inflate(layoutInflater)
        val view = binding.root


        setContentView(view)

        val home = binding.home
        val back = binding.back
        home.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        back.setOnClickListener {
            finish()
        }


        setterItem(GlobalData.dataObject,GlobalData.dO_GlobalIndex)

        val listBtns = binding.linearLayout.children.filterIsInstance<TextView>().toList()
        val newList =  listBtns.filterIndexed { i, _ -> i != 0 }

        readScreen = ReadScreen(this,newList,binding.play)



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


    private fun setterItem(obj: List<InfoDataConstructor>, i: Int) {
        val mutableList = mutableListOf<String>()
        val phoneItem = obj[i].phone
        val lista = listOf(
            obj[i].aten,
            obj[i].addr,
            obj[i].docm,
            obj[i].info,
            obj[i].team,
            obj[i].serv
        )
        lista.forEachIndexed { _, e ->
            if (e.isNotEmpty()) {
                mutableList.add(e)
            }
        }


        infoBuilder(mutableList, obj, i)
        phoneItemConstructor( phoneItem)





    }

    private fun infoBuilder(mList: MutableList<String>, obj: List<InfoDataConstructor>, i: Int) {
        mList.forEachIndexed { index, e ->
            binding.linearLayout.addView(infoItem(e), 4 + index)
        }
        val firstChild = binding.linearLayout.getChildAt(4)
        firstChild.background = ContextCompat.getDrawable(this@UsfStandard, R.drawable.bg_white_top)
        val lastChild = binding.linearLayout.getChildAt(binding.linearLayout.childCount - 1)
        lastChild.background = ContextCompat.getDrawable(this@UsfStandard, R.drawable.bg_white_bot)

        binding.title.text = obj[i].usfName
        if (obj[i].img == 0) {
            binding.linearLayout.removeView(binding.imgMain)
        }
        if (obj[i].img != 0) {
            binding.imgMain.setImageResource(obj[i].img)
        }
    }

    private fun phoneItemConstructor(e: String) {
        val btnLL = CallPhoneBinding.inflate(layoutInflater)
        val btn = btnLL.root

        btnLL.tvcp.text = bolder(e)

        val onlyNumberPhone = e.filter { it.isDigit() }


        if (e.isNotEmpty()) {
            binding.linearLayout.addView(btn, 4 + 1)
        }
        btn.setOnClickListener {
            val phone = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$onlyNumberPhone")
            }
            startActivity(phone)
        }

    }



    private fun btnComplaint(i: Int): AppCompatButton {
        val pddItem = resources.getDimensionPixelSize(R.dimen.paddingUsfItem)
        val complaintIntent = Intent(this@UsfStandard, Complaint::class.java)
        val btn = AppCompatButton(this).apply {
            id = 0
            text = "Formas de realizar uma denúncia:"
            textSize = 24f
            minHeight = resources.getDimensionPixelSize(R.dimen.minHeight)
            textAlignment = View.TEXT_ALIGNMENT_TEXT_START
            background =
                ContextCompat.getDrawable(this@UsfStandard, R.drawable.btn_white)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setPadding(pddItem, pddItem, pddItem, pddItem)
        }
        btn.setOnClickListener {
            complaintIntent.putExtra("COMPINDEX", i-1)
            startActivity(complaintIntent)
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

    private fun viewSpace(): View {
        val view = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(70, 70)
        }
        return view
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
                ContextCompat.getDrawable(context, R.drawable.btn_white)
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
}

