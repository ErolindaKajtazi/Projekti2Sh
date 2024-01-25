package com.example.projekti2sh.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.projekti2sh.R
import com.example.projekti2sh.api.RetrofitClient
import com.example.projekti2sh.models.Student
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> get() = _response

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun registerStudent(student: Student, navController: NavController) {
        _isLoading.value = true
        val apiService = RetrofitClient.createApiService()
        val call = apiService.registerStudent(student)

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    _response.value = response.body()
                    // Redirect to login screen after successful registration
                    navController.navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    _response.value = "Registration failed"
                }
                _isLoading.value = false
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Network error"
                _isLoading.value = false
            }
        })
    }
}