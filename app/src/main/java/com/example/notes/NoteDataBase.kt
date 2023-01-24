package com.example.notes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Notes::class), version = 1, exportSchema = false)
abstract class NoteDataBase :RoomDatabase(){
     abstract fun getNoteDao() : Notedow
     companion object{
         @Volatile
         private var INSTANCE: NoteDataBase? = null

         fun getDatabase(context: Context): NoteDataBase {
             // if the INSTANCE is not null, then return it,
             // if it is, then create the database
             return INSTANCE ?: synchronized(this) {
                 val instance = Room.databaseBuilder(
                     context.applicationContext,
                     NoteDataBase::class.java,
                     "NoteDataBase"
                 ).build()
                 INSTANCE = instance
                 // return instance
                 instance
             }
         }
     }
}