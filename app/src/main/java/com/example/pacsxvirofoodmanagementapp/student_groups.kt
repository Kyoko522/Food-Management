package com.example.pacsxvirofoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class student_groups : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_groups)

        //going to the homepage
        val home_but: Button = this.findViewById(R.id.to_home)
        home_but.setOnClickListener {
            val intent = Intent(this, homepage::class.java)
            startActivity(intent)
        }

        //already on the group page
//        val group_but: Button? = this.findViewById(R.id.groups_page)
//        group_but?.setOnClickListener {
//            val intent = Intent(this, student_groups::class.java)
//            startActivity(intent)
//        }

        //going to the the profile page
        val profile_but: Button = this.findViewById(R.id.to_profile)
        profile_but.setOnClickListener {
            val intent = Intent(this, student_groups::class.java)
            startActivity(intent)
        }
    }
}