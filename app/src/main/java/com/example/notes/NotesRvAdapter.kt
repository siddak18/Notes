package com.example.notes

import android.content.Context
import android.net.wifi.p2p.WifiP2pManager.NetworkInfoListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRvAdapter(private val context: Context, private val listener: Inteerface) :RecyclerView.Adapter<NotesRvAdapter.Noteviewholder>(){
    val allnotes=ArrayList<Notes>()
    inner class Noteviewholder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val textview:TextView=itemView.findViewById(R.id.textView)
        val delete:Button=itemView.findViewById(R.id.buttonhelp)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Noteviewholder {
       val viewholder=Noteviewholder(LayoutInflater.from(context).inflate(R.layout.item_notes,parent,false))
      viewholder.delete.setOnClickListener{
listener.onitemclicked((allnotes[viewholder.adapterPosition]))
      }
       return viewholder
    }

    override fun onBindViewHolder(holder: Noteviewholder, position: Int) {
        val currnote=allnotes[position]
        holder.textview.text=currnote.text
    }

    override fun getItemCount(): Int {
        return allnotes.size
    }
fun updateList(newlist:List<Notes>){
    allnotes.clear()
    allnotes.addAll(newlist)
    notifyDataSetChanged()
}

}
interface Inteerface{
    fun onitemclicked(note:Notes)
}