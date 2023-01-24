package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class noteviewmodel(application: Application) :AndroidViewModel(application) {
    private val repository:NoteRepository
    val allnotes:LiveData<List<Notes>>
    init {
        val dao=NoteDataBase.getDatabase(application).getNoteDao()
         repository=NoteRepository(dao)
        allnotes=repository.allnotes
    }
    fun delete(note:Notes)=viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }
    fun additem(note:Notes)=viewModelScope.launch  (Dispatchers.IO){
      repository.insert(note)
    }
}