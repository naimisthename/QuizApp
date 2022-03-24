package com.example.classtest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.classtest.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var activityResultBinding: ActivityResultBinding
    var totalScore = 0
    var correct = 0
    var wrongScore = 0
    var skipped = 0
    var isKey = false
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityResultBinding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(activityResultBinding.root)

        skipped=intent.getIntExtra("skip",0)
        wrongScore=intent.getIntExtra("wrong",0)
        correct=intent.getIntExtra("correct",0)
        totalScore=intent.getIntExtra("score",0)
        initializeViews()
    }
    @SuppressLint("SetTextI18n")
    private fun initializeViews() {
        activityResultBinding.apply {
            score.text = "Score: $totalScore"
            right.text = "Correct: $correct"
            wrong.text = "Wrong: $wrongScore"
            skip.text = "Skip: $skipped"

            if(totalScore>6)
            {
                activityResultBinding.emojiReactionImg.setImageResource(R.drawable.happy_face)
                Toast.makeText(this@ResultActivity,"Wow Great",Toast.LENGTH_LONG).show()
            }
            else
            {
                activityResultBinding.emojiReactionImg.setImageResource(R.drawable.blank_face)
                Toast.makeText(this@ResultActivity,"Need Improvement",Toast.LENGTH_LONG).show()
            }
            playAgain.setOnClickListener {
                finish()
            }
        }
    }
}