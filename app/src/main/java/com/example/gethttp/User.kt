package com.example.gethttp

import java.io.Serializable


data class User(
    val id: Int,
    val name: String,
    val email: String,
    val address: Address,
    val phone: String
): Serializable

data class Address(
    val city: String
):Serializable
