package com.example.moviematrix.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.moviematrix.MainViewModel
import com.example.moviematrix.R
import com.example.moviematrix.adapter.CinemaAdapter
import com.example.moviematrix.data.model.Cinema
import com.example.moviematrix.databinding.CinemaItemBinding
import com.example.moviematrix.databinding.FragmentCinemaBinding


class FragmentCinema : Fragment() {

    lateinit var binding: FragmentCinemaBinding


    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCinemaBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val cinema = listOf(
            Cinema("Filmwelt Landau", R.drawable.download__1_)
        )

        val recyclerView = CinemaAdapter(requireContext(), cinema)
        binding.recyclerCinema.adapter = recyclerView


    }

}
