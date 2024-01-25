package com.example.projekti2sh.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekti2sh.R
import com.example.projekti2sh.adapter.StudentAdapter
import com.example.projekti2sh.databinding.FragmentHomeBinding
import com.example.projekti2sh.viewModels.HomeViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getAllStudents()
        observeData()
    }

    private fun observeData() {
        viewModel.studentList.observe(viewLifecycleOwner) { studentList ->
            val userAdapter = StudentAdapter(studentList)
            binding.rvStudent.layoutManager = LinearLayoutManager(requireContext())
            binding.rvStudent.adapter = userAdapter
        }

        viewModel.loading.observe(viewLifecycleOwner) {loadingValue ->
            if (loadingValue) binding.progressBar.visibility = View.VISIBLE
            else binding.progressBar.visibility = View.GONE

        }

    }
}