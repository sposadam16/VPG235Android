package com.example.myapplication

import java.util.UUID

class UserDatabase {
    val users = ArrayList<User>()

    init {
        val myMap = HashMap<String, Any>()
        myMap["name"] = "Santiago Posada"
        myMap["email"] = "santi@example.com"
        myMap["password"] = "1234"
        myMap["id"] = UUID.randomUUID()
        users.add(User(myMap))
    }
}