package com.example.moviematrix.ui



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.moviematrix.MainViewModel
import com.example.moviematrix.R
import com.example.moviematrix.databinding.FragmentLoginBinding
import com.example.moviematrix.databinding.FragmentSigninBinding
import com.google.firebase.auth.FirebaseAuth


class FragmentSignin : Fragment() {

    private lateinit var binding: FragmentSigninBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            binding = FragmentSigninBinding.inflate(layoutInflater)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            viewModel.currentUser.observe(viewLifecycleOwner) {
                if (it != null) {
                    findNavController().navigate(R.id.fragmentMap)
                }
            }

            viewModel.toast.observe(viewLifecycleOwner) {
                if (it != null) {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT)
                        .show()
                }
            }

            binding.signinButton.setOnClickListener {
                val mail = binding.signinEmail.text.toString()
                val password = binding.signinPassword.text.toString()

                if (!mail.isNullOrEmpty() && !password.isNullOrEmpty()){
                    viewModel.signUp(mail, password)
                 }
            }
    }
}






