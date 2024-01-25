package com.example.projekti2sh.api

import com.example.projekti2sh.models.LoginRequest
import com.example.projekti2sh.models.Student
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("/api/students/register")
    fun registerStudent(@Body student: Student): Call<String>

    @POST("/api/students/login")
    fun loginStudent(@Body loginRequest: LoginRequest): Call<String>

    @GET("/api/students/students")
    fun getAllStudents() : Call<List<Student>>


}