package com.example.noteapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.databinding.ItemNotesBinding
import com.example.noteapp.model.NoteModel
import com.example.noteapp.view.HomeFragmentDirections

class NotesAdapter(val requireContext: Context, var notesList: List<NoteModel>) :
    RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {

    fun filtering(newFilteredList: ArrayList<NoteModel>) {
        notesList = newFilteredList
        notifyDataSetChanged()
    }

    class notesViewHolder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.notesTitle.text = data.title
        holder.binding.notesSubTitle.text = data.subTitle
        holder.binding.notesDate.text = data.date

        when (data.priority) {
            "1" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.btn_filter_shape_orange)
            }
            "2" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.btn_filter_shape_blue)
            }
            "3" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.btn_filter_shape_pink)
            }
            "4" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.btn_filter_shape_green)
            }
            "5" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.btn_filter_shape_light_pink)
            }
        }

        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount() = notesList.size
}