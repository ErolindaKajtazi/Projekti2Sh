package com.example.projekti2sh.helpers

import android.content.Context
import android.content.SharedPreferences

class Helpers {
    fun provideSharedPreferences(context : Context) : SharedPreferences {
        return context.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
    }

    fun saveStringToSharedPrefs(context: Context, key : String, value : String) {
        provideSharedPreferences(context).edit().apply {
            putString(key,value)
            apply() // replacement of commit() for working async
        }
    }

    fun getStringFromSharedPrefs(context: Context, key : String) : String? {
        return provideSharedPreferences(context).getString(key,"")
    }

    fun saveIntToSharedPrefs(context: Context, key : String, value : Int) {
        provideSharedPreferences(context).edit().apply {
            putInt(key,value)
            apply() // replacement of commit() for working async
        }
    }

    fun getIntFromSharedPrefs(context: Context, key : String) : Int {
        return provideSharedPreferences(context).getInt(key,0)

    }
}