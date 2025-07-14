package br.com.ulbra.ap2quinta.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.ulbra.ap2quinta.data.GameRepository
import br.com.ulbra.ap2quinta.data.local.database.AppDatabase
import br.com.ulbra.ap2quinta.data.mappers.convertToEntity
import br.com.ulbra.ap2quinta.data.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppDatabase.getInstance(application)
    private val gameDao = database.gameDao()
    private val repository = GameRepository(gameDao)

    private val _gamelist = repository.getAllTodos()
    val gameList: LiveData<List<Game>> = _gamelist

    fun insertGame(game: Game) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(game.convertToEntity())
    }

    fun deleteGame(game: Game) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(game.convertToEntity())
    }
}