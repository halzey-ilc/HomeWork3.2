package com.example.homework32.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework32.databinding.ItemNoteBinding
import com.example.homework32.model.NoteModel

class NoteAdapter: ListAdapter<NoteModel, NoteAdapter.ViewHolder>(diffutil) {

    inner class ViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(noteModel: NoteModel) {
            binding.tvTitleItem.text = noteModel.name
            binding.tvDataItem.text = noteModel.age.toString()
            binding.tvDescription.text = noteModel.email
            binding.tvPassword.text = noteModel.password
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.onBind(it)
        }
    }

    companion object {
        private val diffutil = object : DiffUtil.ItemCallback<NoteModel>() {
            override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
                return oldItem.name == newItem.name
            }
            override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}