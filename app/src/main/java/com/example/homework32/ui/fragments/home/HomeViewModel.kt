package com.example.homework32.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework32.model.NoteModel

class HomeViewModel : ViewModel() {

    private val _liveData = MutableLiveData<List<NoteModel>>()
    val liveData: LiveData<List<NoteModel>> = _liveData
    private val noteList = mutableListOf<NoteModel>()

    fun setData(
        name: String,
        age: Int,
        email: String,
        password: String
    ) {
        noteList.add(NoteModel(name = name, age = age, email = email, password = password))
         _liveData . value = noteList . toList ()
    }
}