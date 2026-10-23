package com.example.week3

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

class MainActivity : AppCompatActivity() {
    val users = ArrayList<User>()
    var loggedInUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creamos tres usuarios usando el constructor con HashMap.
        val map1 = HashMap<String, Any>()
        map1["name"] = "Santi"
        map1["email"] = "santi@example.com"
        map1["id"] = UUID.randomUUID()
        users.add(User(map1))

        val map2 = HashMap<String, Any>()
        map2["name"] = "Ana"
        map2["email"] = "ana@example.com"
        map2["id"] = UUID.randomUUID()
        users.add(User(map2))

        val map3 = HashMap<String, Any>()
        map3["name"] = "Luis"
        map3["email"] = "luis@example.com"
        map3["id"] = UUID.randomUUID()
        users.add(User(map3))
    }

    fun login(v: View) {
        val emailInput = EditText(this)
        emailInput.hint = "Email"
        emailInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Login")
        dialog.setMessage("Enter your email")
        dialog.setView(emailInput)
        dialog.setPositiveButton("OK") { _, _ ->
            val email = emailInput.text.toString().trim()
            checkEmail(email)
        }
        dialog.setNegativeButton("Cancel", null)
        dialog.show()
    }

    fun checkEmail(email: String) {
        loggedInUser = null

        // Revisamos los usuarios uno por uno.
        for (user in users) {
            if (user.email == email) {
                loggedInUser = user
                break
            }
        }

        if (loggedInUser != null) {
            Toast.makeText(this, "You were logged in", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Email not found", Toast.LENGTH_LONG).show()
        }
    }
}