package com.example.pacsxvirofoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class activity_profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //going to the homepage
        val to_home: Button = this.findViewById(R.id.go_home)
        to_home.setOnClickListener {
            val intent = Intent(this, homepage::class.java)
            startActivity(intent)
        }

        //going to the group page
        val group_but: Button = this.findViewById(R.id.groups_page)
        group_but.setOnClickListener {
            val intent = Intent(this, student_groups::class.java)
            startActivity(intent)
        }

        //already on the the profile page
        val profile_but: Button = this.findViewById(R.id.to_profile)
        profile_but.setOnClickListener {
            Toast.makeText(this, "Already at profile", Toast.LENGTH_SHORT).show()
        }
    }
}