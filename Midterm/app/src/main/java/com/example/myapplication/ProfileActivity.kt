package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = currentUser
        if (user == null) {
            finish()
            return
        }
        setContentView(R.layout.profile_layout)
        findViewById<TextView>(R.id.profileName).text = user.name
        val info = findViewById<TextView>(R.id.profileInfo)
        if (user.email == "amir@example.com") {
            findViewById<TextView>(R.id.initials).text = "A"
            findViewById<TextView>(R.id.profileRole).text = "Instructor"
            info.text = "Course: Mobile Programming\n\nEmail: " + user.email
        } else {
            findViewById<TextView>(R.id.initials).text = "SP"
            info.text = "Program: Game Development\n\nSemester: 2\n\nInstitution: LaSalleVancouver\n\nStudent ID: 2522613\n\nEmail: " + user.email
        }
    }

    fun goBack(v: View) {
        finish()
    }

    fun logout(v: View) {
        currentUser = null
        finish()
    }
}