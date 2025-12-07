package com.example.quislish.home

import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quislish.R
import com.example.quislish.data.model.Level

class QuizLevelAdapter(
    private var levels: List<Level>,
    private val onClick: (Level) -> Unit
) : RecyclerView.Adapter<QuizLevelAdapter.LevelViewHolder>() {

    inner class LevelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNumber: TextView = itemView.findViewById(R.id.txtLevelNumber)
        val txtTitle: TextView = itemView.findViewById(R.id.txtLevelTitle)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val txtProgress: TextView = itemView.findViewById(R.id.txtProgress)
        val shadowView: View = itemView.findViewById(R.id.shadow_view)
        val containerLayout: LinearLayout = itemView.findViewById(R.id.container_layout)
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

        val color = ContextCompat.getColor(holder.itemView.context, item.color)
        val backgroundColor = ContextCompat.getColor(holder.itemView.context, item.backgroundColor)

        // background layout
        holder.containerLayout.background.mutate().setTint(backgroundColor)

        // shadow view
        (holder.shadowView.background.mutate() as? GradientDrawable)?.setColor(color)

        // number indicator
        holder.txtNumber.background.mutate().setTint(color)

        // progress bar color
        holder.progressBar.progressTintList = ColorStateList.valueOf(color)

        /** CLICK → navigate */
        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount(): Int = levels.size

    /** UPDATE DATA */
    fun updateData(newList: List<Level>) {
        levels = newList
        notifyDataSetChanged()
    }
}