package com.example.freshdesk.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshdesk.api.models.ReportModularly
import com.example.freshdesk.databinding.ItemModularyBottomBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class ReportModularAdapter(private val list: List<ReportModularly>) :
    RecyclerView.Adapter<ReportModularAdapter.ViewHolder>() {
    class ViewHolder(val databinding: ItemModularyBottomBinding) :
        RecyclerView.ViewHolder(databinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemModularyBottomBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.databinding.let {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING
            it.name.text = item.name
            it.openly.text = item.countOfOpenedStatus.toString()
            it.closed.text = item.countOfClosedStatus.toString()
            it.other.text = item.countOfOtherStatus.toString()
            it.total.text = item.total.toString()
            it.percent.text = "${df.format(item.percent)}%"
        }
        if (position % 2 == 0) {
            holder.databinding.let {
                it.moduleCard.setCardBackgroundColor(Color.parseColor("#E7E7E7"))
                it.openlyCard.setCardBackgroundColor(Color.parseColor("#FFEBEB"))
                it.closedCard.setCardBackgroundColor(Color.parseColor("#EFFFEB"))
                it.otherCard.setCardBackgroundColor(Color.parseColor("#E1F6FF"))
                it.totalCard.setCardBackgroundColor(Color.parseColor("#FFF2E6"))
                it.percentCard.setCardBackgroundColor(Color.parseColor("#E4E8FF"))
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}