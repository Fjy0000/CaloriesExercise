package com.example.caloriesexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinnerAge)
        val result: TextView = findViewById(R.id.tvCalories)
        val rgGender: RadioGroup = findViewById(R.id.rgGender)
        val calculate: Button = findViewById(R.id.btnCalculate)
        var rbSelectedisFemale: Boolean = false

        val ages = arrayOf("19-30", "31-59", "60+")
        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ages)
        spinner.adapter = adapter
        spinner.setSelection(0)

        rgGender.setOnCheckedChangeListener { rgGender, checkId ->
            if (checkId == R.id.rbFemale)
                rbSelectedisFemale = true
            if (checkId == R.id.rbMale)
                rbSelectedisFemale = false
        }

        calculate.setOnClickListener()
        {
            result.text = when (rbSelectedisFemale) {
                true -> when (spinner.selectedItemPosition) {
                    0 -> "2000 - 2400 calories"
                    1 -> "1800 - 2200 calories"
                    2 -> "1600 - 2000 calories"
                    else -> "Error"
                }
                else -> when (spinner.selectedItemPosition) {
                    0 -> "2400 - 3000 calories"
                    1 -> "2200 - 3000 calories"
                    2 -> "2000 - 2600 calories"
                    else -> "Error"
                }
            }
        }
    }
}