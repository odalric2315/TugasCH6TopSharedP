package com.percobaan.tugasch6topsharedp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.percobaan.tugasch6topsharedp.databinding.ActivityRegisterBinding
import com.percobaan.tugasch6topsharedp.db.MyDatabase
import com.percobaan.tugasch6topsharedp.db.user
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var myDatabase: MyDatabase
    private lateinit var sharePreferencesHelper: SharePreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myDatabase = MyDatabase.getInstance(this)
        sharePreferencesHelper = SharePreferencesHelper(this)
        if (sharePreferencesHelper.login) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
            binding.btnRegister3.setOnClickListener {
                val name = binding.etNameRegister.text.toString().trim()
                val username = binding.etUsernameRegister.text.toString().trim()
                val password = binding.etPasswordRegister.text.toString().trim()
                val user = user(null, name, username, password)
                GlobalScope.launch {
                    val result = myDatabase.userDao().registerUser(user)
                    if (!result.equals(-1)) {
                        runOnUiThread {
                            Toast.makeText(this@RegisterActivity, "REGISTER SUCCESS", Toast.LENGTH_SHORT).show()
                            binding.etNameRegister.setText("")
                            binding.etUsernameRegister.setText("")
                            binding.etPasswordRegister.setText("")
                        }
                        toLogin()
                    } else {
                        launch(Dispatchers.Main) {
                            Toast.makeText(this@RegisterActivity, "REGISTER FAILED", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        binding.btnTologin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        }
    private fun toLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
    }