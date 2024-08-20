package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityTheendBinding

class theendActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTheendBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTheendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.testagain.setOnClickListener {
            val intent = Intent(this, SubjectoptionActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.logout.setOnClickListener {
            val intent = Intent(this, SighupActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.quit.setOnClickListener {
            finishAffinity()
        }

        }
    }
