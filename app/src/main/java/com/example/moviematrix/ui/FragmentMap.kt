package com.example.moviematrix.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.moviematrix.MainViewModel
import com.example.moviematrix.R
import com.example.moviematrix.databinding.FragmentCinemaBinding
import com.example.moviematrix.databinding.FragmentMapBinding


class FragmentMap : Fragment() {

    lateinit var binding: FragmentMapBinding

    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentUser.observe(viewLifecycleOwner) {
            if(it == null) {
                findNavController().navigate(R.id.fragmentLogin)
            }
        }

        binding.buttonLogout.setOnClickListener {
            viewModel.logout()
        }
        binding.mapButton.setOnClickListener {
            findNavController().navigate(R.id.fragmentCinema)
        }
    }
}
