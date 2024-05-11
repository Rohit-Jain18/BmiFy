package com.example.bmify

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result: TextView = findViewById(R.id.Res)
        val weightInKg: EditText = findViewById(R.id.edtweight)
        val heightInFt: EditText = findViewById(R.id.edtheightft)
        val heightInInch: EditText = findViewById(R.id.edtheightin)
        val btnCalculate: Button = findViewById(R.id.btnSubmit)
        val main: LinearLayout = findViewById(R.id.main)

        btnCalculate.setOnClickListener {
            // Get the values
            val weight = weightInKg.text.toString().toInt()
            val heightFt = heightInFt.text.toString().toInt()
            val heightInch = heightInInch.text.toString().toInt()

            val heightInMeters = (heightFt * 12 + heightInch) / 100.0
            val bmi = weight / (heightInMeters * heightInMeters)

            val bmiResultText: String
            val backgroundColor: Int

            if (bmi > 25) {
                bmiResultText = getString(R.string.you_ve_are_over_weight)
                backgroundColor = ContextCompat.getColor(this, R.color.overweight)
            } else if (bmi < 18) {
                bmiResultText = getString(R.string.you_ve_are_under_weight)
                backgroundColor = ContextCompat.getColor(this, R.color.Underweight)
            } else {
                bmiResultText = getString(R.string.you_ve_are_healthy)
                backgroundColor = Color.GREEN
            }

            result.text = bmiResultText
            main.setBackgroundColor(backgroundColor)
        }
    }
}
