package com.example.pacsxvirofoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerButton: Button = findViewById(R.id.to_register_page)

        registerButton.setOnClickListener {
            val intent = Intent(this, register_page::class.java)
            startActivity(intent)
        }
    }
}
