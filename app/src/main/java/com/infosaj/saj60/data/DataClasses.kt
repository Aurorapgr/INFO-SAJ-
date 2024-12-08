package com.infosaj.saj60.data

import android.content.Intent

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
data class UsfConstructor(
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
data class NavInfo(
    val id: String,
    val title: String,
    val tabInfo : List<String>
)