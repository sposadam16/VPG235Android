package com.example.week3

import java.util.UUID

class User() {
    var name: String? = null
    lateinit var email: String
    lateinit var id: UUID

    constructor(myMap: HashMap<String, Any>) : this() {
        // Cada clave permite obtener un valor del mapa.
        name = myMap["name"] as String?
        email = myMap["email"] as String
        id = myMap["id"] as UUID
    }
}