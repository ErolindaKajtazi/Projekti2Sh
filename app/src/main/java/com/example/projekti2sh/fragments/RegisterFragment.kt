package com.example.projekti2sh.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.projekti2sh.R
import com.example.projekti2sh.databinding.ActivityMainBinding
import com.example.projekti2sh.databinding.FragmentRegisterBinding
import com.example.projekti2sh.models.Student
import com.example.projekti2sh.viewModels.RegisterViewModel


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            val student = Student(
                id = 0, // or any default value for the ID
                name = binding.editTextName.text.toString(),
                email = binding.editTextEmail.text.toString(),
                password = binding.editTextPass.text.toString()
            )
//            // Use Safe Args to navigate to LoginFragment with the Student object
//            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment(student)
//            findNavController().navigate(action)

            viewModel.registerStudent(student, findNavController())
        }
    }



}