package com.geekbrains.android_1.hw3_1.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.android_1.hw3_1.R
import com.geekbrains.android_1.hw3_1.data.entity.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter: RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent,
                    false))

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(notes[position])

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(note: Note) = with(itemView) {
            tv_title.text = note.title
            tv_text.text = note.text
            setBackgroundColor(note.color)
        }
    }
}

