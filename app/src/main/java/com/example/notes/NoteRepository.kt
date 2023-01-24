package com.example.notes

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData

class NoteRepository(private val notedow: Notedow) {
    val allnotes:LiveData<List<Notes>> =notedow.getAllNotes()
    suspend fun insert(note:Notes){
        notedow.insert(note)
    }
     suspend fun delete(note:Notes){
         notedow.delete(note)
     }

}