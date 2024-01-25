package com.example.projekti2sh.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projekti2sh.api.ApiService
import com.example.projekti2sh.api.RetrofitClient
import com.example.projekti2sh.models.Student
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _studentList : MutableLiveData<List<Student>> = MutableLiveData(mutableListOf())
    private val apiService: ApiService = RetrofitClient.createApiService()

    val studentList : LiveData<List<Student>>
        get() = _studentList

    private val _loading : MutableLiveData<Boolean> = MutableLiveData(false)
    val loading : LiveData<Boolean>
        get() = _loading

//    fun getUserList() : LiveData<List<User>> {
//        return _userList
//    }

    fun getAllStudents() {
        _loading.value = true
        apiService.getAllStudents().enqueue(object : Callback<List<Student>?> {
            override fun onResponse(call: Call<List<Student>?>, response: Response<List<Student>?>) {
                _loading.value = false
                if (response.isSuccessful && response.body() != null) {
                    _studentList.value = response.body()!!
                }
            }

            override fun onFailure(call: Call<List<Student>?>, t: Throwable) {
                _loading.value = false
//                Toast.makeText(requireContext(),"Call not being made", Toast.LENGTH_LONG).show()
            }
        })
    }
}