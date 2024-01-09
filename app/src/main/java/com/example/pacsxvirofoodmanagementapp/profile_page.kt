package com.example.pacsxvirofoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class profile_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        //Going to the homepage
        val home_button: Button = findViewById(R.id.to_home)
        home_button.setOnClickListener {
            val intent = Intent(this, homepage::class.java)
            startActivity(intent)
        }

        //Already on the groups page
        val groups_button: Button = findViewById(R.id.to_groups)
        groups_button.setOnClickListener {
            val intent = Intent(this, groups_page::class.java)
            startActivity(intent)
        }

        //Going to the Profile page
        val profile_button: Button = findViewById(R.id.to_profile)
        profile_button.setOnClickListener {
            Toast.makeText(this,"Already on Profile Page", Toast.LENGTH_SHORT).show()
        }

    }
}