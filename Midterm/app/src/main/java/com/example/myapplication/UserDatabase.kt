package com.example.myapplication

import java.util.UUID

// Accounts and tasks stay in memory only while the app is running.
val database = UserDatabase()
var currentUser: User? = null

class UserDatabase {
    val users = ArrayList<User>()

    init {
        val santi = addUser("Santiago Posada", "santi@example.com")
        santi.tasks.add(Task("Mobile Programming: finish the layout"))
        santi.tasks.add(Task("Math: solve the exercises"))
        santi.tasks.add(Task("English: practice the presentation"))
        santi.tasks.add(Task("Databases: draw the diagram"))

        val amir = addUser("Amir", "amir@example.com")
        amir.tasks.add(Task("Mobile Programming: review the layouts"))
        amir.tasks.add(Task("Math: prepare the quiz"))
        amir.tasks.add(Task("English: review the presentations"))
        amir.tasks.add(Task("Databases: grade the diagrams"))
    }

    private fun addUser(name: String, email: String): User {
        val myMap = HashMap<String, Any>()
        myMap["name"] = name
        myMap["email"] = email
        myMap["password"] = "1234"
        myMap["id"] = UUID.randomUUID()
        val user = User(myMap)
        users.add(user)
        return user
    }
}