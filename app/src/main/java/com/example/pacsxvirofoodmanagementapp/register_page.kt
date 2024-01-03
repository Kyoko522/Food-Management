package com.example.pacsxvirofoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.analytics.FirebaseAnalytics
import java.net.PasswordAuthentication
import com.google.firebase.FirebaseApp

class register_page : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_register_page)

			val login_button: Button = findViewById(R.id.back_to_login)
			val register_button: Button= findViewById(R.id.register)
			val name_editview: EditText = findViewById(R.id.name)
			val username_editview: EditText = findViewById(R.id.username)
			val password_1_editview: EditText = findViewById(R.id.password)
			val password_2_editview: EditText = findViewById(R.id.password2)

			login_button.setOnClickListener {
				val intent = Intent(this, MainActivity::class.java)
				startActivity(intent)
			}

			name_editview.setOnFocusChangeListener { _, z ->
				if(z){
					name_editview.text.clear()
				}
			}

			username_editview.setOnFocusChangeListener { _, a ->
				if (a){
					username_editview.text.clear()
				}
			}

			password_1_editview.setOnFocusChangeListener { _, b ->
				if (b){
					password_1_editview.text.clear()
				}
			}

			password_2_editview.setOnFocusChangeListener { _, c ->
				if (c){
					password_2_editview.text.clear()
				}
			}

		register_button.setOnClickListener {
			val username = username_editview.text.toString()
			val password1 = password_1_editview.text.toString()
			val password2 = password_2_editview.text.toString()

			if (validate_input(username, password1, password2)) {
				FirebaseAuth.getInstance().createUserWithEmailAndPassword(username, password1)
					.addOnCompleteListener { task ->
						if (task.isSuccessful) {
							val firebaseUser: FirebaseUser = task.result!!.user!!
							showPopupMessage("You are registered successfully.")

							val intent = Intent(this, home::class.java)
							intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
							intent.putExtra("user_id", firebaseUser.uid)
							intent.putExtra("email_id", username)
							startActivity(intent)
							finish()

						} else {
							// Handle registration failure
							showPopupMessage("Registration failed: ${task.exception?.message}")
						}
					}
			} else {
				print("here")
			}
		}
	}

	private fun validate_input(username: String, password: String, password2: String): Boolean {
		if (username.trim().isNotEmpty() && password.trim().isNotEmpty() && password2.trim().isNotEmpty()) {
			if (username != "username" && password != "Passwords" && password2 != "Re-type Password") {
				if (password == password2) {
					return true
				} else {
					showPopupMessage("Passwords don't match")
					return false
				}
			} else {
				showPopupMessage("Cannot set username to 'username' or password to 'password'")
				return false
			}
		} else {
			showPopupMessage("All fields are required")
			return false
		}
	}

	private fun showPopupMessage(message: String) {
		val builder = AlertDialog.Builder(this)
		val customView = layoutInflater.inflate(R.layout.custom_alert_dialog, null)
		builder.setView(customView)

		val messageTextView: TextView = customView.findViewById(R.id.messageTextView)
		val okButton: Button = customView.findViewById(R.id.okButton)

		messageTextView.text = message
		messageTextView.setTextColor(ContextCompat.getColor(this, R.color.dark_green))
		okButton.setTextColor(ContextCompat.getColor(this, R.color.light_green))
		okButton.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_green))

		val dialog = builder.create()

		okButton.setOnClickListener {
			dialog.dismiss()
		}

		dialog.show()
	}
}

