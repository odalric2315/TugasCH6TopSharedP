package com.percobaan.tugasch6topsharedp

import android.content.Context
import android.content.SharedPreferences

class SharePreferencesHelper(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("MyPref",Context.MODE_PRIVATE)

    companion object{
        const val NAME = "name"
        const val LOGIN = "login"
    }
    var name : String?
        get() {
            return sharedPreferences.getString(NAME, "No Data")
        }
        set(value) {
            sharedPreferences.edit().putString(NAME,value).apply()
        }

    var login : Boolean
        get() {
            return sharedPreferences.getBoolean(LOGIN,false)
        }
        set(value) {
            sharedPreferences.edit().putBoolean(LOGIN,value).apply()
        }

    fun removeSharePref(key: String){
        sharedPreferences.edit().remove(key).apply()
    }

    fun clearSharePref(){
        sharedPreferences.edit().clear().apply()
    }
}