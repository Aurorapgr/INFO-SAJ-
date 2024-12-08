package com.infosaj.saj60

import android.content.Context
import android.content.Intent
import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.net.Uri
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import com.infosaj.saj60.databinding.CallPhoneBinding
import com.infosaj.saj60.databinding.CallPhoneCustomBinding
import com.infosaj.saj60.databinding.GenericBtnBinding
import com.infosaj.saj60.databinding.InfoItemBinding
import com.infosaj.saj60.databinding.PhoneEmergenBtnBinding


fun Activity.btnEmerg(title:String,tel: String) : LinearLayout{
    val btnLL = PhoneEmergenBtnBinding.inflate(layoutInflater)
    val btn = btnLL.root

    btnLL.titleBtn.text = title
    btnLL.tvcp.text = tel

    val onlyNumberPhone = tel.filter { it.isDigit() }

    btnLL.callPhoneBtn.setOnClickListener{
        val phone = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$onlyNumberPhone")
        }
        startActivity(phone)
    }

    return btn
}

fun Activity.btnEmerg2(tel: String) : LinearLayout{
    val btnLL = CallPhoneCustomBinding.inflate(layoutInflater)
    val btn = btnLL.root

    btnLL.tvcp.text = tel

    val onlyNumberPhone = tel.filter { it.isDigit() }

    btnLL.callPhoneBtn.setOnClickListener{
        val phone = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$onlyNumberPhone")
        }
        startActivity(phone)
    }

    return btn
}


fun genericView(context: Context):View{
    return View(context).apply {
        layoutParams = LinearLayout.LayoutParams(70,70)
    }
}

fun Activity.infoItem(text: String):TextView{
    val textView = InfoItemBinding.inflate(layoutInflater)
    textView.root.text = bolder(text)
    return textView.root
}

fun bolder(text: String): SpannableString {
    val bolderText = SpannableString(text)
    if (text.isNotEmpty()){
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

fun genericTitle(context: Context,text: String): TextView{
    return TextView(context).apply {
        this.text = text
        textSize = 34f
        setTextColor(Color.WHITE)
        gravity = Gravity.CENTER
        setTypeface(typeface,Typeface.BOLD)
    }
}

fun Activity.btnSections(context: Context,text: String):TextView{
    val textView = GenericBtnBinding.inflate(layoutInflater)
    textView.root.text = text
    return textView.root
 }

fun createImageView(context: Context,img:Int): ImageView {
    return ImageView(context).apply {
        id = View.generateViewId()
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            context.resources.getDimensionPixelSize(R.dimen.image_height_250dp)
        )
        setBackgroundColor(ContextCompat.getColor(context, R.color.purple))
        setImageResource(img)
    }
}

