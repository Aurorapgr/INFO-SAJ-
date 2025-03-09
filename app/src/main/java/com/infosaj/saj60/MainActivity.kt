package com.infosaj.saj60

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.speech.tts.TextToSpeech
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.infosaj.saj60.data.GlobalData
import com.infosaj.saj60.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var binding : ActivityMainBinding
    private lateinit var textToSpeech: TextToSpeech
    private var isTTSInitialized = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        val nextIntent = Intent(this, GenericView::class.java)

        val listBtns = listOf(
            binding.toSaude,
            binding.toAssistSocial,
            binding.toLazerEduca,
            binding.toDireitosSeguran
        )



        binding.toSaude.setOnClickListener {
            GlobalData.rPT = 0
            startActivity(nextIntent)
        }
        binding.toAssistSocial.setOnClickListener {
            GlobalData.rPT = 5
            startActivity(nextIntent)
        }
        binding.toLazerEduca.setOnClickListener {
            GlobalData.rPT = 6
            startActivity(nextIntent)
        }
        binding.toDireitosSeguran.setOnClickListener {
            GlobalData.rPT = 7
            startActivity(nextIntent)
        }









        binding.emerg.setOnClickListener {
            startActivity(Intent(this, Emergen::class.java))
        }
        binding.infotab.setOnClickListener {
            startActivity(Intent(this, InfoWindowns::class.java))
        }

        setContentView(view)

        //inicializa o tts
        textToSpeech = TextToSpeech(this,this)


        binding.play.setOnClickListener {
            startReadBtns(listBtns)
        }


    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            textToSpeech.language = Locale("pt","BR")
            isTTSInitialized = true
        }
    }

    private fun startReadBtns(btns:List<AppCompatButton>){
        btns.forEachIndexed{index,btn ->
            btn.postDelayed({
                setStrokeBtns(btn)
                speak(btn.text.toString())
            },(index * 2000L))
        }
    }

    private fun setStrokeBtns(appCompatButton: AppCompatButton){
        val borderDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setStroke(8, Color.BLACK)
            cornerRadius = 30f
        }

        val defaultBG : Drawable? = appCompatButton.background
        val layers = arrayOf(defaultBG,borderDrawable)

        val layerDrawable = LayerDrawable(layers)

        appCompatButton.background = layerDrawable

        appCompatButton.postDelayed({
            appCompatButton.background = defaultBG
        },2000L)

    }

    private fun speak(text: String){
        if(isTTSInitialized){
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null,null)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.stop()
        textToSpeech.shutdown()
    }

}