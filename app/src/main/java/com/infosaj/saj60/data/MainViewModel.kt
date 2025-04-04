package com.infosaj.saj60.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private val _test = MutableLiveData<Int>()

    val test: LiveData<Int> = _test


    init {
        _test.value = 90909

    }

    fun updateText (newText:Int){
        _test.value = newText
    }
}