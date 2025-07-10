package br.com.ulbra.ap2quinta.data

import br.com.ulbra.ap2quinta.data.model.Game

class GameRepository {
    private var gameList = listOf(
        Game(
            id = 1,
            name = "The Legend of Zelda: Breath of the Wild",
            description = "Ação e aventura em mundo aberto com exploração e resolução de puzzles.",
            publisher = "Nintendo",
            launchYear = 2017,
            imgPath = "@drawable/zelda"
        ),
        Game(
            id = 2,
            name = "God of War Ragnarök",
            description = "Kratos e Atreus enfrentam os desafios do Ragnarok na mitologia nórdica.",
            publisher = "Sony Interactive Entertainment",
            launchYear = 2022,
            imgPath = "@drawable/gow"
        ),
        Game(
            id = 3,
            name = "Red Dead Redemption 2",
            description = "Um épico do velho oeste com narrativa envolvente e mundo realista.",
            publisher = "Rockstar Games",
            launchYear = 2018,
            imgPath = "@drawable/rdr2"
        ),
        Game(
            id = 4,
            name = "The Witcher 3: Wild Hunt",
            description = "Jogo de RPG com mundo aberto, cheio de histórias ricas e combates intensos.",
            publisher = "CD Projekt",
            launchYear = 2015,
            imgPath = "@drawable/tw3"
        ),
        Game(
            id = 5,
            name = "Elden Ring",
            description = "RPG de ação em mundo aberto com design de Hidetaka Miyazaki e George R. R. Martin.",
            publisher = "Bandai Namco Entertainment",
            launchYear = 2022,
            imgPath = "@drawable/ering"
        ),
        Game(
            id = 6,
            name = "Minecraft",
            description = "Jogo sandbox de construção e sobrevivência com blocos e infinitas possibilidades.",
            publisher = "Mojang Studios",
            launchYear = 2011,
            imgPath = "@drawable/mine"
        ),
        Game(
            id = 7,
            name = "GTA V",
            description = "Ação em mundo aberto com três protagonistas em Los Santos.",
            publisher = "Rockstar Games",
            launchYear = 2013,
            imgPath = "@drawable/gtav"
        ),
        Game(
            id = 8,
            name = "Hollow Knight",
            description = "Metroidvania com arte desenhada à mão e ambientação sombria e profunda.",
            publisher = "Team Cherry",
            launchYear = 2017,
            imgPath = "@drawable/hollow"
        ),
        Game(
            id = 9,
            name = "Cyberpunk 2077",
            description = "RPG futurista em mundo aberto com narrativa densa e personalização profunda.",
            publisher = "CD Projekt",
            launchYear = 2020,
            imgPath = "@drawable/cyber"
        ),
        Game(
            id = 10,
            name = "Super Mario Odyssey",
            description = "Mario viaja por mundos diversos com mecânicas inovadoras e criativas.",
            publisher = "Nintendo",
            launchYear = 2017,
            imgPath = "@drawable/mario"
        )
    )

    fun getList() = gameList

    fun setList(lista: List<Game>) {
        this.gameList = lista
    }

}