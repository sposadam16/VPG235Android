package com.example.myapplication

import java.util.UUID

class User() {
    var name: String? = null
    lateinit var email: String
    lateinit var password: String
    lateinit var id: UUID

    constructor(myMap: HashMap<String, Any>) : this() {
        name = myMap["name"] as String?
        email = myMap["email"] as String
        password = myMap["password"] as String
        id = myMap["id"] as UUID
    }
}