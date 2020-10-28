package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.quizapp.Constants.score
import kotlinx.android.synthetic.main.activity_question.*
import java.lang.StringBuilder

class QuestionActivity : AppCompatActivity() {

    private var mCurrentPosition = 1
    private lateinit var mQuestionList: ArrayList<Question>
    private var mSelectedOptions = 0
    private var isAnswerChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        mQuestionList = Constants.getQuestions()
        showQuestion()
        btn_submit_answer.setOnClickListener {
            if (!isAnswerChecked) {
                if(mSelectedOptions == 0) {
                    Toast.makeText(this, "Please select answer", Toast.LENGTH_SHORT).show()
                } else {
                    checkAnswer()
                    isAnswerChecked = true
                }

            } else {
                mCurrentPosition += 1
                if (mCurrentPosition > 10) {
                    val intent = Intent(this, ResultActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    showQuestion()
                }
                isAnswerChecked = false
            }
            mSelectedOptions = 0
        }
    }
    private fun showQuestion() {
        val question = mQuestionList[mCurrentPosition - 1]
        tv_answer_one.setBackgroundResource(R.drawable.text_view_round)
        tv_answer_two.setBackgroundResource(R.drawable.text_view_round)
        tv_answer_three.setBackgroundResource(R.drawable.text_view_round)
        tv_answer_four.setBackgroundResource(R.drawable.text_view_round)
        tv_answer_one.text = question.optionOne
        tv_answer_two.text = question.optionTwo
        tv_answer_three.text = question.optionThree
        tv_answer_four.text = question.optionFour
        iv_question_image.setImageResource(question.image)
        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition/ ${progressBar.max}"
    }

    fun showCheckButton(view: View) {
        val clickedButton = view as TextView
        when(clickedButton.id) {
            R.id.tv_answer_one -> {
                tv_answer_one.setBackgroundResource(R.drawable.edit_text_check)
                tv_answer_two.setBackgroundResource(R.drawable.text_view_round)
                tv_answer_three.setBackgroundResource(R.drawable.text_view_round)
                tv_answer_four.setBackgroundResource(R.drawable.text_view_round)
                mSelectedOptions = 1
            }
            R.id.tv_answer_two -> {
                tv_answer_one.setBackgroundResource(R.drawable.text_view_round)
                tv_answer_two.setBackgroundResource(R.drawable.edit_text_check)
                tv_answer_three.setBackgroundResource(R.drawable.text_view_round)
                tv_answer_four.setBackgroundResource(R.drawable.text_view_round)
                mSelectedOptions = 2
            }
            R.id.tv_answer_three -> {
                tv_answer_one.setBackgroundResource(R.drawable.text_view_round)
                tv_answer_two.setBackgroundResource(R.drawable.text_view_round)
                tv_answer_three.setBackgroundResource(R.drawable.edit_text_check)
                tv_answer_four.setBackgroundResource(R.drawable.text_view_round)
                mSelectedOptions = 3
            }
            R.id.tv_answer_four -> {
                tv_answer_one.setBackgroundResource(R.drawable.text_view_round)
                tv_answer_two.setBackgroundResource(R.drawable.text_view_round)
                tv_answer_three.setBackgroundResource(R.drawable.text_view_round)
                tv_answer_four.setBackgroundResource(R.drawable.edit_text_check)
                mSelectedOptions = 4
            }
        }
    }

    private fun checkAnswer() {
        val question = mQuestionList[mCurrentPosition - 1]
        if (question.correctAnswer == mSelectedOptions) {
            when(mSelectedOptions) {
                1 -> tv_answer_one.setBackgroundResource(R.drawable.text_view_correct)
                2 -> tv_answer_two.setBackgroundResource(R.drawable.text_view_correct)
                3 -> tv_answer_three.setBackgroundResource(R.drawable.text_view_correct)
                4 -> tv_answer_four.setBackgroundResource(R.drawable.text_view_correct)
            }
            score += 1
        } else {
            when(question.correctAnswer) {
                1 -> tv_answer_one.setBackgroundResource(R.drawable.text_view_correct)
                2 -> tv_answer_two.setBackgroundResource(R.drawable.text_view_correct)
                3 -> tv_answer_three.setBackgroundResource(R.drawable.text_view_correct)
                4 -> tv_answer_four.setBackgroundResource(R.drawable.text_view_correct)
            }
            when(mSelectedOptions) {
                1 -> tv_answer_one.setBackgroundResource(R.drawable.text_view_wrong)
                2 -> tv_answer_two.setBackgroundResource(R.drawable.text_view_wrong)
                3 -> tv_answer_three.setBackgroundResource(R.drawable.text_view_wrong)
                4 -> tv_answer_four.setBackgroundResource(R.drawable.text_view_wrong)
            }
        }
    }
}