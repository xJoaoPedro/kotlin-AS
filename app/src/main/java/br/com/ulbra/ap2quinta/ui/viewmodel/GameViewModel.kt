package br.com.ulbra.ap2quinta.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ulbra.ap2quinta.data.GameRepository
import br.com.ulbra.ap2quinta.data.model.Game

class GameViewModel: ViewModel() {
    private val repository = GameRepository()

    private val _gamelist = MutableLiveData<List<Game>>()
    val gameList: LiveData<List<Game>> = _gamelist

    init {
        _gamelist.value = repository.getList()
    }

    fun deleteGame(game: Game) {
        val newList = repository.getList().filter { it.id != game.id }
        repository.setList(newList)
        _gamelist.value = newList
    }
}