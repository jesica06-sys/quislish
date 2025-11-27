package com.example.quislish

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quislish.databinding.ItemLessonBinding
import com.example.quislish.LessonItem

class LessonAdapter(
    private val list: List<LessonItem>,
    private val onClick: (LessonItem) -> Unit
) : RecyclerView.Adapter<LessonAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemLessonBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LessonItem) {
            binding.textTitle.text = item.title
            binding.textDescription.text = item.description
            binding.cardContainer.setCardBackgroundColor(item.color)

            itemView.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLessonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
