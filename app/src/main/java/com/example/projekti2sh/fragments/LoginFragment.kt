package com.example.projekti2sh.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.projekti2sh.R
import com.example.projekti2sh.databinding.FragmentLoginBinding
import com.example.projekti2sh.viewModels.LoginViewModel


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize NavController

        binding.loginButton.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val navController = findNavController()

            // Pass the NavController to the ViewModel
            viewModel.login(email, password, navController)
        }

        // Observe the response LiveData for any changes
        viewModel.response.observe(viewLifecycleOwner, Observer { response ->
            // Handle the response, for example, show an error toast
            Toast.makeText(requireContext(), response, Toast.LENGTH_SHORT).show()
        })
    }
}