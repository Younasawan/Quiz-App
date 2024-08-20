package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityScore2Binding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScore2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityScore2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.score.setText("Congrats!!! Your Score Is ${intent.getIntExtra("SCORE", 0)}")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, theendActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
        }
    }
