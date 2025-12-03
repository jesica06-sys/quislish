package com.example.quislish.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quislish.R
import com.example.quislish.data.model.UserRank
import android.widget.TextView
import android.widget.LinearLayout


class WorldRankAdapter(
    private val items: List<UserRank>
) : RecyclerView.Adapter<WorldRankAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val txtRank = view.findViewById<TextView>(R.id.txtRank)
        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtPoints = view.findViewById<TextView>(R.id.txtPoints)
        val container = view.findViewById<LinearLayout>(R.id.container_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_world_rank, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.txtRank.text = item.rank.toString()
        holder.txtName.text = item.name
        holder.txtPoints.text = "✦${item.points}"

        // Dynamic color background
        holder.container.setBackgroundResource(item.colorRes)
    }
}
