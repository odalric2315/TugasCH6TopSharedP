package com.percobaan.tugasch6topsharedp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.percobaan.tugasch6topsharedp.databinding.ActivityMainBinding
import com.percobaan.tugasch6topsharedp.db.MyDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharePreferencesHelper: SharePreferencesHelper
    private lateinit var myDatabase: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePreferencesHelper = SharePreferencesHelper(this)

    binding.btnClose.setOnClickListener {
        sharePreferencesHelper.removeSharePref(SharePreferencesHelper.LOGIN)
        sharePreferencesHelper.removeSharePref(SharePreferencesHelper.NAME)
        startActivity(Intent(this, RegisterActivity::class.java))
        finish()
    }
    }
}