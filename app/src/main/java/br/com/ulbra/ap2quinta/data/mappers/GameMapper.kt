package br.com.ulbra.ap2quinta.data.mappers

import br.com.ulbra.ap2quinta.data.local.entities.GameEntity
import br.com.ulbra.ap2quinta.data.model.Game

fun GameEntity.convertToModel() =
    Game(
        this.id,
        this.name,
        this.description,
        this.publisher,
        this.launchYear
    )

fun Game.convertToEntity() =
    GameEntity(
        this.id,
        this.name,
        this.description,
        this.publisher,
        this.launchYear
    )