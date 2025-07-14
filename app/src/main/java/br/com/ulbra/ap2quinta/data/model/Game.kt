package br.com.ulbra.ap2quinta.data.model

import java.io.Serializable

data class Game (
    val id: Int,
    val name: String,
    val description: String,
    val publisher: String,
    val launchYear: Int
): Serializable