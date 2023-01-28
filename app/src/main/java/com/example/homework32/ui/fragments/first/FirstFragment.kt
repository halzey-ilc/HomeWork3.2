package com.example.homework32.ui.fragments.first
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.homework32.R
import com.example.homework32.databinding.FragmentFirstBinding
import com.example.homework32.model.NoteModel
import com.example.homework32.ui.fragments.home.HomeViewModel

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnAdd.setOnClickListener {
            val etName = binding.editTextUserName.text.toString().trim()
            val etAge = binding.editTextAge.text.toString().toInt()
            val etEmail = binding.editTextEmail.text.toString().trim()
            val etPass = binding.editTextPassword.text.toString().trim()
            viewModel.setData(name = etName, age = etAge, email = etEmail, password = etPass)
            findNavController().navigateUp()

        }
    }
}