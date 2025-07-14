package br.com.ulbra.ap2quinta.data.local.entities;

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey(autoGenerate = true)

    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val publisher: String = "",
    val launchYear: Int = 0,
)