package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        supportActionBar?.hide()


        Handler(Looper.getMainLooper()).postDelayed({
             val intent = Intent(this, SighupActivity::class.java)
             startActivity(intent)
            finish()
        }, 3000)
    }
}
