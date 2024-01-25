package com.example.projekti2sh.models

import java.io.Serializable

data class Student(
    var id: Long, //val
    var name: String,
    var email: String,
    var password: String,
//    var imageUrl: String

) : Serializable