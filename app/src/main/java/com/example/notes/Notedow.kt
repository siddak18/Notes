package com.example.notes

import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Notedow {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(note :Notes)

     @Delete
     fun delete(note:Notes)

     @Query("Select * from notes_table order by id Asc")

     fun getAllNotes():LiveData<List<Notes>>

}