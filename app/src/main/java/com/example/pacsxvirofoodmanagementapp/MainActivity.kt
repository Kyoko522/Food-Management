package com.example.pacsxvirofoodmanagementapp

import android.app.admin.TargetUser
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import java.net.PasswordAuthentication
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val register_button: Button = findViewById(R.id.to_register_page)
        val username_editfield: EditText = findViewById(R.id.username)
        val password_editfield: EditText = findViewById(R.id.password)
        val login_button: Button = findViewById(R.id.login)

        username_editfield.setOnFocusChangeListener { _, a ->
            if (a){
                username_editfield.text.clear()
            }
        }

        password_editfield.setOnFocusChangeListener { _, b ->
            if (b){
                password_editfield.text.clear()
            }
        }
        register_button.setOnClickListener {
            val intent = Intent(this, register_page::class.java)
            startActivity(intent)
        }



        login_button.setOnClickListener {
//            remove this when trying to use login page (Temporary to skip login page and test homepage layout)
            val intent1 = Intent(this,homepage::class.java)
            startActivity(intent1)

            val username = username_editfield.text.toString()
            val password = password_editfield.text.toString()

            if (validate_input(username, password)){
                //go to the other screen where they will be able do something when login in

                FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener { task ->

                        if(task.isSuccessful){
                            //Toast.makeText(this, "Login was Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, homepage::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)

                            intent.putExtra("email_id", username)
                            startActivity(intent)
                            finish()
                        }
                        else{
                            Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else{
                Toast.makeText(this,"All field are required", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun validate_input (username: String, password: String): Boolean{
        return username.trim().isNotEmpty() && password.trim().isNotEmpty()
    }
}
