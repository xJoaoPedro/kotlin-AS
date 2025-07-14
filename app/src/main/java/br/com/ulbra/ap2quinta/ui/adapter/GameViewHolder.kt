package br.com.ulbra.ap2quinta.ui.adapter

import android.view.View
import android.widget.TextView
import br.com.ulbra.ap2quinta.R
import androidx.recyclerview.widget.RecyclerView
import br.com.ulbra.ap2quinta.data.model.Game

class GameViewHolder(
    itemView: View,
    private val onDelete: (Game) -> Unit,
    private val onDetails: (Game) -> Unit,
    private val onEdit: (Game) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.gameName)
    private val description: TextView = itemView.findViewById(R.id.gameDescription)
    private val publisher: TextView = itemView.findViewById(R.id.gamePublisher)
    private val launchYear: TextView = itemView.findViewById(R.id.gameLaunchYear)
    private val actionEdit: TextView = itemView.findViewById(R.id.editButton)
    private val actionDelete: TextView = itemView.findViewById(R.id.actionDelete)
    private val actionDetails: TextView = itemView.findViewById(R.id.actionDetails)

    fun bind(game: Game) {
        name.text = game.name
        description.text = game.description
        publisher.text = game.publisher
        launchYear.text = game.launchYear.toString()

        actionEdit.setOnClickListener {
            onEdit(game)
        }

        actionDelete.setOnClickListener {
            onDelete(game)
        }

        actionDetails.setOnClickListener {
            onDetails(game)
        }
    }
}
