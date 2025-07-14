package br.com.ulbra.ap2quinta.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.ulbra.ap2quinta.R
import br.com.ulbra.ap2quinta.data.model.Game
import br.com.ulbra.ap2quinta.ui.viewmodel.GameViewModel

class EditFormGameFragment : Fragment() {
    val args: EditFormGameFragmentArgs by navArgs()
    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_form_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val game = args.game

        val edtName = view.findViewById<EditText>(R.id.edtNameEdit)
        edtName.setText(game.name)

        val edtDescription = view.findViewById<EditText>(R.id.edtDescriptionEdit)
        edtDescription.setText(game.description)

        val edtPublisher = view.findViewById<EditText>(R.id.edtPublisherEdit)
        edtPublisher.setText(game.publisher)

        val edtLaunchYear = view.findViewById<EditText>(R.id.edtLaunchYearEdit)
        edtLaunchYear.setText(game.launchYear.toString())

        val button = view.findViewById<Button>(R.id.editButton)

        button.setOnClickListener {
            val launchYearInt = edtLaunchYear.text.toString().toIntOrNull() ?: 0

            val updatedGame = Game(
                id = game.id,
                name = edtName.text.toString(),
                description = edtDescription.text.toString(),
                publisher = edtPublisher.text.toString(),
                launchYear = launchYearInt
            )

            gameViewModel.updateGame(updatedGame)

            val action = EditFormGameFragmentDirections.voltarParaListaDoEdit()
            findNavController().navigate(action)
        }
    }
}