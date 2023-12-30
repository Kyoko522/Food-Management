package com.example.pacsxvirofoodmanagementapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pacsxvirofoodmanagementapp.ui.main.RegisterPageFragment

class register_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RegisterPageFragment.newInstance())
                .commitNow()
        }
    }
}