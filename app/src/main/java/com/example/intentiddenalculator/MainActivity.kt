package com.example.intentiddenalculator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var  textTV:TextView
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textTV = findViewById(R.id.textTV)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            launchCalc.launch(intent)
        }

    }

    private val launchCalc = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        activity ->
        if (activity.resultCode == RESULT_OK) {
            val result = activity.data!!.getStringExtra("result")
            textTV.text=result
        }
    }
}