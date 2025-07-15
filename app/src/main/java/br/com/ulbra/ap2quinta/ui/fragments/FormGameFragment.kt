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
import br.com.ulbra.ap2quinta.R
import br.com.ulbra.ap2quinta.data.model.Game
import br.com.ulbra.ap2quinta.databinding.FragmentFormGameBinding
import br.com.ulbra.ap2quinta.ui.viewmodel.GameViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlin.text.toIntOrNull


class FormGameFragment : Fragment() {
    private lateinit var binding: FragmentFormGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FormGameFragment.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.addButton)
        val name = view.findViewById<TextInputEditText>(R.id.edtName)
        val description = view.findViewById<TextInputEditText>(R.id.edtDescription)
        val publisher = view.findViewById<TextInputEditText>(R.id.edtPublisher)
        val launchYear = view.findViewById<TextInputEditText>(R.id.edtLaunchYear)

        button.setOnClickListener {
            val launchYearInt = launchYear.text.toString().toIntOrNull() ?: 0

            val game = Game(
                id = 0,
                name = name.text.toString(),
                description = description.text.toString(),
                publisher = publisher.text.toString(),
                launchYear = launchYearInt
            )

            gameViewModel.insertGame(game)

            val action = FormGameFragmentDirections.voltarParaListaDeJogos()
            findNavController().navigate(action)
        }
    }

    companion object
}

private fun FormGameFragment.Companion.inflate(
    inflater: LayoutInflater,
    container: ViewGroup?,
    bool: Boolean
): View? {
}
