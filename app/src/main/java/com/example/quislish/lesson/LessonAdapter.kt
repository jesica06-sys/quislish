package com.example.quislish.lesson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quislish.lesson.LessonItem
import com.example.quislish.databinding.ItemLessonBinding

// Adapter untuk RecyclerView yang menampilkan daftar Lesson
class LessonAdapter(
    private val list: List<LessonItem>,
    private val onClick: (LessonItem) -> Unit
) : RecyclerView.Adapter<LessonAdapter.ViewHolder>() {

    // ViewHolder menampung tampilan setiap item
    inner class ViewHolder(val binding: ItemLessonBinding)
        : RecyclerView.ViewHolder(binding.root) {

        // Fungsi untuk mengisi data ke elemen tampilan
        fun bind(item: LessonItem) {
            binding.textTitle.text = item.title
            binding.textDescription.text = item.description
            binding.cardContainer.setCardBackgroundColor(item.color)

            itemView.setOnClickListener {
                onClick(item)
            }
        }
    }

    // Membuat ViewHolder baru saat dibutuhkan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLessonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    // Menghubungkan data pada posisi tertentu ke ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    // Jumlah total item dalam list
    override fun getItemCount(): Int = list.size
}