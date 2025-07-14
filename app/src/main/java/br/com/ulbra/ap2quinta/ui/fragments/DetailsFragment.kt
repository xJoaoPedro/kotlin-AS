package br.com.ulbra.ap2quinta.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import br.com.ulbra.ap2quinta.R

class DetailsFragment : Fragment() {
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val game = args.game

        view.findViewById<TextView>(R.id.idGame).text = game.id.toString()
        view.findViewById<TextView>(R.id.gameName).text = game.name
        view.findViewById<TextView>(R.id.gameDescription).text = game.description
        view.findViewById<TextView>(R.id.gamePublisher).text = game.publisher
        view.findViewById<TextView>(R.id.gameLaunchYear).text = game.launchYear.toString()
    }
}