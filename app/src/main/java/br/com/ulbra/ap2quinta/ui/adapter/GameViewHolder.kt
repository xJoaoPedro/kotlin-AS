package br.com.ulbra.ap2quinta.ui.adapter

import android.view.View
import android.widget.TextView
import br.com.ulbra.ap2quinta.R
import androidx.recyclerview.widget.RecyclerView
import br.com.ulbra.ap2quinta.data.model.Game
import br.com.ulbra.ap2quinta.databinding.GameItemListBinding

class GameViewHolder(
    private val binding: GameItemListBinding,
    private val onDelete: (Game) -> Unit,
    private val onDetails: (Game) -> Unit,
    private val onEdit: (Game) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(game: Game) {
        binding.game = game

        binding.editButton.setOnClickListener {
            onEdit(game)
        }

        binding.actionDelete.setOnClickListener {
            onDelete(game)
        }

        binding.actionDetails.setOnClickListener {
            onDetails(game)
        }

//        binding.gameCheck.addOnCheckedStateChangedListener {_, _ ->
//            binding.game = game
//        }
    }
}
