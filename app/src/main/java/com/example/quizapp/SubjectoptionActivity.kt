package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivitySubjectoptionBinding

class SubjectoptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubjectoptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectoptionBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.computer.setOnClickListener{
            val intent = Intent(this, computerActivity::class.java)
            intent.putExtra("Subject", "Computer")
            startActivity(intent)
            finish()
        }

       binding.english.setOnClickListener {
            val intent = Intent(this, EnglishActivity::class.java)
            intent.putExtra("Subject", "English")
            startActivity(intent)
           finish()
        }

          binding.maths.setOnClickListener {
             val intent = Intent(this, MathsActivity::class.java)
             intent.putExtra("Subject", "Maths")
             startActivity(intent)
              finish()
         }

                 binding.history.setOnClickListener {
                     val intent = Intent(this, HistoryActivity::class.java)
                     intent.putExtra( "Subject", "History")
                     startActivity(intent)
                     finish()
                 }
    }
}