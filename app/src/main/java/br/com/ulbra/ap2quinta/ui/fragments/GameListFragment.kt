package br.com.ulbra.ap2quinta.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.ulbra.ap2quinta.R
import br.com.ulbra.ap2quinta.databinding.FragmentGameListBinding
import br.com.ulbra.ap2quinta.ui.adapter.GameAdapter
import br.com.ulbra.ap2quinta.ui.viewmodel.GameViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class GameListFragment : Fragment() {
    private var _binding: FragmentGameListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: GameAdapter
    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gameViewModel.gameList.observe(viewLifecycleOwner) { games ->
            adapter.submitList(games)
        }

        _binding = FragmentGameListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<FloatingActionButton>(R.id.fabAdd)

        button.setOnClickListener {
            val action = GameListFragmentDirections.navegarParaForm()
            findNavController().navigate(action)
        }

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)

        adapter = GameAdapter(
            onDelete = { game ->
                gameViewModel.deleteGame(game)

                Snackbar.make(
                    view.context,
                    recycler,
                    "Zerado com sucesso!",
                    Snackbar.LENGTH_SHORT
                ).show()
            },
            onDetails = { game ->
                val action  = GameListFragmentDirections.navegarParaDetalhes(game)
                findNavController().navigate(action)
            },
            onEdit = { game ->
                val action = GameListFragmentDirections.navegarParaEdit(game)
                findNavController().navigate(action)
            }
        )

        recycler.adapter = adapter
    }
}