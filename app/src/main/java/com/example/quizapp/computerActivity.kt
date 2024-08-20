package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityComputerBinding

class computerActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityComputerBinding
    private lateinit var list:ArrayList<QuestionModel>
    private var count:Int = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityComputerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList<QuestionModel>()
        list.add(QuestionModel("What is 'R' stands for RAM?", "Random" ,"Reality", "Royal" , "Range", "Random" ))
        list.add(QuestionModel("Which is an operating system?", "Python" ,"HTML", "Windows" , "CSS", "Windows" ))
        list.add(QuestionModel("What is HTML used for?", "Programming" ,"Scripting", "Styling" , "Markup", "Scripting" ))
        list.add(QuestionModel("What is a byte?", "8 Bits" ,"16 Bits", "24 Bits" , "32 Bits", "8 Bits" ))
        list.add(QuestionModel("Which is a web browser?", "Linux" ,"Kalli", "MacOS" , "Chrome", "Chrome" ))


        binding.question.setText(list.get(0).question)
        binding.option1.setText(list.get(0).option1)
        binding.option2.setText(list.get(0).option2)
        binding.option3.setText(list.get(0).option3)
        binding.option4.setText(list.get(0).option4)

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
