package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var usernameEditText: EditText
    lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        usernameEditText = findViewById(R.id.nameEditText_id)
        passwordEditText = findViewById(R.id.passwordEditText)
    }

    fun signIn(v: View) {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (username == "santi" && password == "1234") {
            loggedIn = true
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            passwordEditText.error = "Use username santi and password 1234"
        }
    }

    fun goBack(v: View) {
        finish()
    }
}

