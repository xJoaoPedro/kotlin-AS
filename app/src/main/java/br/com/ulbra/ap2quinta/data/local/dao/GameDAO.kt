package br.com.ulbra.ap2quinta.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.ulbra.ap2quinta.data.local.entities.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDAO {

    @Insert
    suspend fun insertGame(gameEntity: GameEntity)

    @Query("SELECT * FROM games")
    fun getAllGames(): Flow<List<GameEntity>>

    @Delete
    suspend fun deleteGame(gameEntity: GameEntity)
}
