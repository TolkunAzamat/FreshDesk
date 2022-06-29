package com.example.freshdesk.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshdesk.api.models.ReportInDynamic
import com.example.freshdesk.databinding.ItemDynamicRecyclerBinding

class DynamicAdapter (private val list: List<ReportInDynamic>): RecyclerView.Adapter<DynamicAdapter.ViewHolder>() {
    class ViewHolder(val databinding: ItemDynamicRecyclerBinding) :
        RecyclerView.ViewHolder(databinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDynamicRecyclerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.databinding.let {
            it.status.text=item.status
            it.total.text=item.total.toString()
            it.persent.text=item.percent.toString()
            it.previosDayGet.text=item.previosDayGet.toString()
            it.previosDaySet.text=item.previosDaySet.toString()
            it.forWeekGet.text=item.forWeekGet.toString()
            it.forWeekSet.text=item.forWeekSet.toString()
            it.forMonthGet.text=item.forMonthkGet.toString()
            it.forMonthSet.text=item.forForMonthSet.toString()
        }
        if(position%2==0){
            holder.databinding.let{
                it.statusCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                it.percentCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                it.forWeekCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
            }
        }
    }

    override fun getItemCount(): Int {
return list.size
    }
}