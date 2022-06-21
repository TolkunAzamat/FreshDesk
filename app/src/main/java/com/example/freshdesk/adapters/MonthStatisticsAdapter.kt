package com.example.freshdesk.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshdesk.api.models.ReportMonthlyItem
import com.example.freshdesk.databinding.ItemMonthRecyclerBinding
class MonthStatisticsAdapter(private val list: List<ReportMonthlyItem>):RecyclerView.Adapter<MonthStatisticsAdapter.ViewHolder>() {
    class ViewHolder(val databinding:ItemMonthRecyclerBinding):RecyclerView.ViewHolder(databinding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMonthRecyclerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.databinding.let {
            it.month.text = item.nameOfMonth
            it.bug.text = item.countOfCreatedTicketsWithTypeError.toString()
            it.other.text = item.countOfTicketsWithOtherTypes.toString()
            it.total.text = item.countOfCreatedTickets.toString()
            it.done.text = item.countOfClosedTicketsInThisMonth.toString()
            it.difference.text = item.difference.toString()
        }
    }
    override fun getItemCount(): Int {
      return list.size
    }
}