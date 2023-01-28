package com.example.homework32.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.homework32.R
import com.example.homework32.databinding.FragmentHomeBinding
import com.example.homework32.model.NoteModel
import com.example.homework32.ui.adapters.NoteAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var noteadapter = NoteAdapter()
    private val viewModel by activityViewModels<HomeViewModel>()
    private lateinit var arrayUserList: ArrayList<NoteModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
        navigations()
        setupClick()
    }

    private fun onClick() {
        binding.recyclerViewNote.adapter = noteadapter
    }

    private fun navigations() {
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.firstFragment)
        }
    }

    private fun setupClick() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            noteadapter.submitList(it)
        }
    }
}