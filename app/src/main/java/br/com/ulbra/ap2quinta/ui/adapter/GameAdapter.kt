package br.com.ulbra.ap2quinta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import br.com.ulbra.ap2quinta.R
import br.com.ulbra.ap2quinta.data.model.Game

class GameAdapter(
    private val onDelete: (Game) -> Unit,
    private val onDetails: (Game) -> Unit
) : ListAdapter<Game, GameViewHolder>(GameDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.game_item_list, parent, false)

        return GameViewHolder(itemView = itemView, onDelete = onDelete, onDetails = onDetails)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}