package com.example.quislish


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quislish.R  // sesuaikan package


class QuizLevelAdapter(
    private val levels: List<Level>,
    private val onClick: (Level) -> Unit
) : RecyclerView.Adapter<QuizLevelAdapter.LevelViewHolder>() {

    inner class LevelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNumber: TextView = itemView.findViewById(R.id.txtLevelNumber)
        val txtTitle: TextView = itemView.findViewById(R.id.txtLevelTitle)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val txtProgress: TextView = itemView.findViewById(R.id.txtProgress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_quis_level, parent, false)
        return LevelViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        val item = levels[position]

        holder.txtNumber.text = item.id.toString()
        holder.txtTitle.text = item.title
        holder.progressBar.max = item.total
        holder.progressBar.progress = item.progress
        holder.txtProgress.text = "${item.progress}/${item.total}"

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount(): Int = levels.size
}
