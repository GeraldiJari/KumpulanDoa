// Doa.kt
package com.example.kumpulandoa

import java.io.Serializable

data class Doa(
    val id: Int = 0,
    val title: String = "",
    val arabic: String = "",
    val latin: String = "",
    val translation: String = ""
) : Serializable
