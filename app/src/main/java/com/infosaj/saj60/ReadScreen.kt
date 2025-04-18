package com.infosaj.saj60

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.media.Image
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import java.util.Locale

class ReadScreen(context: Context, private val btns : List<TextView>, private val player : ImageView): TextToSpeech.OnInitListener  {
    private var tts: TextToSpeech = TextToSpeech(context,this)
    private var cIdx = 0
    var isReading = false

    //Detalhe interessante pra fixar na mente: Isso aqui é uma interface, não uma herança
    //Interface é como se você estivesse "herdando" um comportamento ou função para um novo objeto
    // Diferente de herança que você esta criando um objeto da mesma classe que o do objeto herado

    init {
        tts.setOnUtteranceProgressListener(object  : android.speech.tts.UtteranceProgressListener(){
            override fun onStart(utteranceId : String?){

                btns[cIdx].post{
                    setStrokeBtns(btns[cIdx])
                }
            }

            override fun onDone(utteranceId: String?) {
                //Leitura terminou, já chama a próxima
                if (cIdx in btns.indices) {
                    clearStroke(btns[cIdx])
                }
                cIdx++
                if (cIdx < btns.size){
                    readBtns(cIdx)
                }
            }

            override fun onError(utteranceId: String?) {
            }

            override fun onStop(utteranceId: String?, interrupted: Boolean) {
                isReading = false
                if (cIdx in btns.indices) {
                    clearStroke(btns[cIdx])
                }
            }
        })

    }
    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            tts.language = Locale("pt","BR")
        }
    }

    fun startReadBtns(){
        isReading = true
        player.setImageResource(R.drawable.bx_pause_circle)
        if (btns.isNotEmpty()){
            cIdx = 0
            readBtns(cIdx)
        }
    }

    fun stopReadBtns(){
        isReading = false
        player.setImageResource(R.drawable.megaphone)
        tts.stop()
        if (cIdx in btns.indices) {
            clearStroke(btns[cIdx])
        }
    }
    fun highlightButton(view: View) {
       if (view is ImageView){
           view.setImageResource(R.drawable.bx_pause_circle)

       }
    }

    fun clearHighlightButton(view: View) {
        if (view is ImageView){
            view.setImageResource(R.drawable.megaphone)
        }
    }



    private fun readBtns(idx: Int) {
        val btn = btns[idx]
        val text = btn.text.toString()
        val params = Bundle()
        //Só pra fixar, Bundle é uma caixa de armazenamento de dados
        params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "ID${idx}")


        tts.setSpeechRate(1f)
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, params, "ID${idx}")


    }

    private fun setStrokeBtns(view: View){

        val defaultBG : Drawable? = view.background

        val borderDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setStroke(8, Color.BLACK)
            cornerRadius = 30f
        }


        val layers = arrayOf(defaultBG,borderDrawable)
        val layerDrawable = LayerDrawable(layers)

        view.post {
            view.background = layerDrawable
        }
    }

    private  fun clearStroke(view: View ){
        val defaultBG : Drawable? = view.background

        val borderDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setStroke(8, Color.WHITE)
            cornerRadius = 30f
        }


        val layers = arrayOf(defaultBG,borderDrawable)
        val layerDrawable = LayerDrawable(layers)

        view.post {
            view.background = layerDrawable
        }
    }
}