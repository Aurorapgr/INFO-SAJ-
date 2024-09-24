package com.infosaj.saj60

object Data{
    val usfs = listOf(
        UsfContructor(
            id = "ubsCF",
            usfName = "UBS CASACA DE FERRO",
            serv = "bbbb",
            addr = "socoro",
            phone = "AAAASdasdsa"),


    )
}

val teste = Data.usfs

fun main(){
    println(teste[0])
}
