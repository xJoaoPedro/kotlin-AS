package br.com.ulbra.ap2quinta.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import br.com.ulbra.ap2quinta.data.local.dao.GameDAO
import br.com.ulbra.ap2quinta.data.local.entities.GameEntity
import br.com.ulbra.ap2quinta.data.mappers.convertToModel
import br.com.ulbra.ap2quinta.data.model.Game
import kotlinx.coroutines.flow.map

class GameRepository(private val gameDAO: GameDAO) {

    fun getAllTodos(): LiveData<List<Game>> {
        return gameDAO.getAllGames().map { item -> item.map { game -> game.convertToModel() } }.asLiveData()
    }

    suspend fun insert(gameEntity: GameEntity) {
        gameDAO.insertGame(gameEntity)
    }

    suspend fun update(gameEntity: GameEntity) {
        gameDAO.updateGame(gameEntity)
    }

    suspend fun delete(gameEntity: GameEntity) {
        gameDAO.deleteGame(gameEntity)
    }
}