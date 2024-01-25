package com.example.projekti2sh.models

import java.io.Serializable

data class LoginRequest(
    var email: String, // val
    var password: String
) : Serializable 