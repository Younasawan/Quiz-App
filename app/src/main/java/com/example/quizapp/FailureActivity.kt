package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityFailureBinding

class FailureActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFailureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFailureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.failure.setText("Fail!!! Your Score Is ${intent.getIntExtra("SCORE",0)}")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent (this, theendActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
        }
    }
