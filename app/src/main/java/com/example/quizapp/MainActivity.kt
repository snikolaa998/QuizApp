@file:Suppress("DEPRECATION")

package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        btn_start_quiz.setOnClickListener {
            if (et_activity_main_name.text.isNotEmpty()) {
                val intent = Intent(this, QuestionActivity::class.java)
                Constants.userName = et_activity_main_name.text.toString()
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Enter a name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}