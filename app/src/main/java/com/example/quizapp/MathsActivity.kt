package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityEnglishBinding
import com.example.quizapp.databinding.ActivityMathsBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MathsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMathsBinding
    private lateinit var list:ArrayList<QuestionModel>
    private var count:Int = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMathsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        list = ArrayList<QuestionModel>()
        Firebase.firestore.collection("Maths").get().addOnSuccessListener {
                doct->
            list.clear()
            for (i in doct.documents) {
                var questionModel = i.toObject(QuestionModel::class.java)
                list.add(questionModel!!)
            }
            binding.question.setText(list.get(0).question)
            binding.option1.setText(list.get(0).option1)
            binding.option2.setText(list.get(0).option2)
            binding.option3.setText(list.get(0).option3)
            binding.option4.setText(list.get(0).option4)
        }

        binding.option1.setOnClickListener{
            nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener{
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener{
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener{
            nextData(binding.option4.text.toString())
        }

    }

    private fun nextData(i: String) {
        if (count<list.size){
            if (list.get(count).ans.equals(i)){
                score++
            }
        }
        count++
        if (count>=list.size){
            if (score>=3) {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                startActivity(intent)
                finish()
            }
            else if (score<3){
                val intent = Intent(this, FailureActivity::class.java)
                intent.putExtra("SCORE", score)
                startActivity(intent)
                finish()
            }
        }
        else {
            binding.question.setText(list.get(count).question)
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }
    }
}