package com.infosaj.saj60

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.infosaj.saj60.databinding.ActivityMainBinding

class Testact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cLayout = ConstraintLayout(this).apply {
            layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT)
        }


        val textV = TextView(this).apply {
            id = View.generateViewId()
            text = "AAAAAAAAAAAPORRA"
            textSize = 24f

            layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT )
        }
        val button = Button(this).apply{
            id = View.generateViewId()
            text = "BOTÃO"
            setBackgroundColor(0xFF0000FF.toInt())
            layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT )
        }

        cLayout.addView(textV)
        cLayout.addView(button)


        val constraintSet = ConstraintSet()
        constraintSet.clone(cLayout)

        constraintSet.connect(
            textV.id,
            ConstraintSet.TOP,
            ConstraintSet.PARENT_ID,
            ConstraintSet.TOP,
            100)
        constraintSet.connect(
            button.id,
            ConstraintSet.TOP,
            textV.id,
            ConstraintSet.BOTTOM,
            0)

        constraintSet.applyTo(cLayout)
        setContentView(cLayout)
    }
}