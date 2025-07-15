package br.com.ulbra.ap2quinta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import br.com.ulbra.ap2quinta.R
import br.com.ulbra.ap2quinta.data.model.Game
import br.com.ulbra.ap2quinta.databinding.GameItemListBinding

class GameAdapter(
    private val onDelete: (Game) -> Unit,
    private val onDetails: (Game) -> Unit,
    private val onEdit: (Game) -> Unit
) : ListAdapter<Game, GameViewHolder>(GameDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding =
            GameItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GameViewHolder(binding = binding, onDelete = onDelete, onDetails = onDetails, onEdit = onEdit)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}