package com.example.homescreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homescreen.databinding.ItemHistoryBinding
import com.example.homescreen.entity.HistoryEntity

class HistoryAdapter(private var historyList: MutableList<HistoryEntity>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val historyItem = historyList[position]

        // Access views using binding
        holder.binding.tvIndex.text = "${position + 1}."
        holder.binding.tvUrl.text = historyItem.url
        holder.binding.tvTime.text = "Visited: ${historyItem.time}"
    }

    override fun getItemCount(): Int = historyList.size

    fun updateList(newList: List<HistoryEntity>) {
        historyList.clear()
        historyList.addAll(newList)
        notifyDataSetChanged()
    }

    fun getHistoryList(): List<HistoryEntity> = historyList.toList()
}
