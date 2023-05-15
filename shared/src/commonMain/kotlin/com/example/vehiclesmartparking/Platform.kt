package com.example.vehiclesmartparking

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform