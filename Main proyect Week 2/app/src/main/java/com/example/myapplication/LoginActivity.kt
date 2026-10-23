package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    val database = UserDatabase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        emailEditText = findViewById(R.id.nameEditText_id)
        passwordEditText = findViewById(R.id.passwordEditText)
    }

    fun signIn(v: View) {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()
        var found = false

        for (user in database.users) {
            if (user.email == email && user.password == password) {
                found = true
                break
            }
        }

        if (found == true) {
            passwordEditText.error = null
            loggedIn = true

            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Login successful")
            dialog.setMessage("You were logged in")
            dialog.setIcon(R.drawable.ic_check_green)
            dialog.setCancelable(false)
            dialog.setPositiveButton("OK") { _, _ ->
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
            dialog.show()
        } else {
            passwordEditText.error = "Incorrect email or password"
        }
    }

    fun goBack(v: View) {
        finish()
    }
}