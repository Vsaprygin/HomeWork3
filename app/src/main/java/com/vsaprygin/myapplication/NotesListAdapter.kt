package com.vsaprygin.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vsaprygin.myapplication.databinding.NotesListItemBinding

class NotesListAdapter : RecyclerView.Adapter<NotesListViewHolder>() {

    var items = mutableListOf<Notes>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var itemClick: (Notes) -> Unit = {}
    fun itemClick(listener: (Notes) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_list_item, parent, false)
        return NotesListViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesListViewHolder, position: Int) {
        holder.binding.notes = items[position]
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
class NotesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var binding = NotesListItemBinding.bind(view)

}