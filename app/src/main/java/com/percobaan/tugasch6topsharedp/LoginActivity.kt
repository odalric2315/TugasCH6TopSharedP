package com.percobaan.tugasch6topsharedp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.percobaan.tugasch6topsharedp.databinding.ActivityLoginBinding
import com.percobaan.tugasch6topsharedp.db.MyDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var preferencesHelper: SharePreferencesHelper
    private lateinit var myDatabase: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDatabase = MyDatabase.getInstance(this)
        preferencesHelper = SharePreferencesHelper(this)
     binding.btnLogin.setOnClickListener {
         val username = binding.etUsername.text.toString().trim()
         val password = binding.etPassword.text.toString().trim()
         GlobalScope.launch {
             val user = myDatabase.userDao().loginUser(username, password)
             if (user != null) {
                 runOnUiThread {
                     Toast.makeText(this@LoginActivity, "LOGIN SUCCESS", Toast.LENGTH_SHORT)
                         .show()
                 }
                 preferencesHelper.name = user.name
                 preferencesHelper.login = true
                 toHome()
             } else {
                 runOnUiThread {
                     Toast.makeText(this@LoginActivity, "LOGIN FAILED", Toast.LENGTH_SHORT)
                         .show()
                 }
             }
         }
         binding.etPassword.setText("")
         binding.etUsername.setText("")
     }
     binding.btnRegister2.setOnClickListener {
         val intent = Intent(this, RegisterActivity::class.java)
         startActivity(intent)
     }
    }
    private fun toHome() {
        val intent = Intent(this, RegisterActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}