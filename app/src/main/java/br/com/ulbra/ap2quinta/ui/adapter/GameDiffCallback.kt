package br.com.ulbra.ap2quinta.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.ulbra.ap2quinta.data.model.Game

class GameDiffCallback : DiffUtil.ItemCallback<Game>() {
    // Verifica se os IDs dos itens são iguais
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean = oldItem.id == newItem.id

    // Verifica se o conteúdo do item mudou
    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean = oldItem == newItem
}
