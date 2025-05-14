package com.infosaj.saj60.data

data class CompliantConstructor(
    val title: String,
    val name: String,
    val img: Int,
    val info0: String,
    val info1: String,
    val info2: String,
    val info3: String,
    val info4: String
)
data class EPC(
    val title: String,
    val phone1: String,
    val phone2: String
)

data class ITDB(
    val info1: String,
    val info2: String,
    val info3: String,
    val info4: String
)
data class InfoDataConstructor(
    val img: Int,
    val id: Int,
    val usfName: String,
    val aten:String,
    val addr:String,
    val phone:String,
    val email: String,
    val insta : String,
    val info: String,
    val docm : String,
    val serv: String,
    val team : String)

data class Tela(
    val title: String,
    val btns: List<Btn>
)

data class Btn(
    val title: String,
    val refpt: Int?,
    val act : Class<*>?,
    val dObj : List<InfoDataConstructor>?,
    val index : Int?
)
