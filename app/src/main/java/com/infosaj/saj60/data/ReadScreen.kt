package com.infosaj.saj60.data

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.appcompat.widget.AppCompatButton
import java.util.Locale

class ReadScreen(context: Context, private val btns : List<AppCompatButton>): TextToSpeech.OnInitListener  {
    private var tts: TextToSpeech = TextToSpeech(context,this)
    private var cIdx = 0

    //Detalhe interessante pra fixar na mente: Isso aqui é uma interface, não uma herança
    //Interface é como se você estivesse "herdando" um comportamento ou função para um novo objeto
    // Diferente de herança que você esta criando um objeto da mesma classe que o do objeto herado

    init {
        tts.setOnUtteranceProgressListener(object  : android.speech.tts.UtteranceProgressListener(){
            override fun onStart(utteranceId : String?){
                //post serve pra executar após a formação completa da UI
                btns[cIdx].post{
                    setStrokeBtns(btns[cIdx],true)
                }
            }

            override fun onDone(utteranceId: String?) {
                //Leitura terminou, já chama a próxima
                cIdx++
                if (cIdx < btns.size){
                    readBtns(cIdx)

                }
            }

            override fun onError(utteranceId: String?) {
                TODO("Not yet implemented")
            }
        })

    }
    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            tts.language = Locale("pt","BR")
        }
    }

    fun startReadBtns(){
        if (btns.isEmpty()){
            cIdx = 0
            readBtns(cIdx)
        }
    }

    private fun readBtns(idx: Int) {
        val btn = btns[idx]
        val text = btn.text.toString()
        val params = Bundle()
        //Só pra fixar, Bundle é uma caixa de armazenamento de dados
        params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "ID${idx}")

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, params, "ID${idx}")

        setStrokeBtns(btn,false)

    }

    private fun setStrokeBtns(appCompatButton: AppCompatButton, act: Boolean){

        val defaultBG : Drawable? = appCompatButton.background

        val borderDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setStroke(8, if (act) Color.BLACK else Color.TRANSPARENT)
            cornerRadius = 30f
        }


        val layers = arrayOf(defaultBG,borderDrawable)
        val layerDrawable = LayerDrawable(layers)

        appCompatButton.post {
            appCompatButton.background = layerDrawable
        }

    }
}