package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Inteerface {
    lateinit var viewModel:noteviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        finallap.layoutManager= LinearLayoutManager(this)
        val adapter=NotesRvAdapter(this,this)
        finallap.adapter=adapter
        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(noteviewmodel::class.java)
        viewModel.allnotes.observe(this, Observer {List->
            List?.let{
                adapter.updateList(it)
            }

        })

    }

    override fun onitemclicked(note: Notes) {
        viewModel.delete(note)
    }

    fun subbmithis(view: View) {
        val notetext=editTextTextPersonName.text.toString()
        if(notetext.isNotEmpty()){
            viewModel.additem(Notes(notetext))
        }
    }
}