package org.meliante.kotlincalculator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform