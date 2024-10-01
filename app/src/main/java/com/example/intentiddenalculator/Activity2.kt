package com.example.intentiddenalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var buttonPlus: Button
    private lateinit var buttonMinus: Button
    private lateinit var buttonMult:Button
    private lateinit var buttonDiv: Button
    private lateinit var buttonSend: Button
    private lateinit var textRes:TextView
    var result=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        buttonPlus=findViewById(R.id.buttonPlus)
        buttonMinus=findViewById(R.id.buttonMinus)
        buttonMult=findViewById(R.id.buttonMult)
        buttonDiv=findViewById(R.id.buttonDiv)
        buttonSend=findViewById(R.id.buttonSend)
        textRes=findViewById(R.id.textRes)

        buttonPlus.setOnClickListener{calculate('+')}
        buttonMinus.setOnClickListener{calculate('-')}
        buttonMult.setOnClickListener{calculate('*')}
        buttonDiv.setOnClickListener{calculate('/')}

        buttonSend.setOnClickListener {
            result = result.trim()
            if (result.isEmpty()) result = "Считать нечего"
            val intent = Intent()
            intent.putExtra("result", result)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun calculate(operator: Char) {
        val num1 = editText1.text.toString().toInt()
        val num2 = editText2.text.toString().toInt()
        if (num2 == 0) result = "Делить на ноль нельзя!"
        else {
            result = when (operator) {
                '+' -> (num1 + num2).toString()
                '-' -> (num1 - num2).toString()
                '*' -> (num1 * num2).toString()
                '/' -> (num1 / num2).toString()
                else -> "0"
            }
        }
        textRes.text=result.trim()
    }

}

