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
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.view.updateLayoutParams
import com.infosaj.saj60.data.DirSegData
import com.infosaj.saj60.data.LazerEducData
import com.infosaj.saj60.data.UsfConstructor
import com.infosaj.saj60.data.Data
import com.infosaj.saj60.databinding.ActivityUsfStandardBinding
import com.infosaj.saj60.databinding.CallPhoneBinding

class UsfStandard : AppCompatActivity() {
    private lateinit var binding: ActivityUsfStandardBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        window.statusBarColor = ContextCompat.getColor(this, R.color.purple)

        super.onCreate(savedInstanceState)

        binding = ActivityUsfStandardBinding.inflate(layoutInflater)
        val view = binding.root


        val dbUFRB = Data.servUFRB
        val dbUSF = Data.servUFRB
        val dbONGS = Data.servUFRB
        val dbASSSOCIAL = Data.assSocial
        val dbLE = LazerEducData.lazerEduca
        val dbDS = DirSegData.dirSeg
        val dbSUS = Data.sus

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

        val extraUFRB = intent.getIntExtra("UFRBINDEX", 300)
        val extraSUS = intent.getIntExtra("SUSINDEX", 400)
        val extraDS = intent.getIntExtra("DSINDEX", 500)
        val extraLE = intent.getIntExtra("LEINDEX", 600)
        val extraAS = intent.getIntExtra("ASINDEX", 700)
        val extraUSF = intent.getIntExtra("USFINDEX", 800)
        val extraONGS = intent.getIntExtra("ONGSINDEX", 900)


        if (extraUFRB != 300) {
            setterItem(dbUFRB, extraUFRB)
            if(extraUFRB == 1){
                binding.linearLayout.addView(btnLinks("https://www.ufrb.edu.br/ccs/"))
            }
        }
        if (extraSUS != 400) {
            setterItem(dbSUS, extraSUS)
        }
        if (extraDS != 500) {
            setterItem(dbDS, extraDS)
            if (extraDS == 1 || extraDS == 2) {
                binding.linearLayout.addView(viewSpace())
                binding.linearLayout.addView(btnComplaint(extraDS))
            }
        }
        if (extraLE != 600) {
            setterItem(dbLE, extraLE)
        }
        if (extraAS != 700) {
            setterItem(dbASSSOCIAL, extraAS)
        }
        if (extraUSF != 800) {
            setterItem(dbUSF, extraUSF)
        }
        if (extraONGS != 900) {
            setterItem(dbONGS, extraONGS)
        }


    }

    private fun setterItem(obj: List<UsfConstructor>, i: Int) {
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
        lista.forEachIndexed { i, e ->
            if (e.isNotEmpty()) {
                mutableList.add(e)
            }
        }


        infoBuilder(mutableList, obj, i)
        phoneItemConstructor(100, 1, phoneItem)
    }

    private fun infoBuilder(mList: MutableList<String>, obj: List<UsfConstructor>, i: Int) {
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

    private fun phoneItemConstructor(Id: Int, i: Int, e: String) {
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

