package com.percobaan.tugasch6topsharedp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            Toast.makeText(this,"Welcome", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        },3000)
    }
}