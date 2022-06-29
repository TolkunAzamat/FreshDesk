package com.example.freshdesk.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.freshdesk.api.models.ReportMonthly
import com.example.freshdesk.databinding.ItemMonthRecyclerBinding
import com.github.mikephil.charting.charts.LineChart

class MonthStatisticsAdapter :RecyclerView.Adapter<MonthStatisticsAdapter.ViewHolder>() {
    class ViewHolder(val databinding:ItemMonthRecyclerBinding):RecyclerView.ViewHolder(databinding.root){}
    private var list: List<ReportMonthly> = mutableListOf()
    private var positions:Int?=null
    private var index:Int?=null
    private var lineChart: LineChart? = null
    fun setList(list: List<ReportMonthly>) {
        this.list = list
    }
    fun setPos(position: Int?,indexSet:Int?){
        positions=position
        index=indexSet
    }
    fun setLine(lineChart: LineChart){
        this.lineChart=lineChart
    }
    private fun onClick(card:CardView, index: Int, position: Int){
      card.setOnClickListener {
          lineChart?.highlightValue(position.toFloat(), index, true)
      }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMonthRecyclerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        var cards= listOf(
        holder.databinding.bugCard,
        holder.databinding.otherCard,
        holder.databinding.totalCard,
        holder.databinding.doneCard,
        holder.databinding.differenceCard)

        holder.databinding.let {
            it.month.text = item.nameOfMonth
            it.bug.text = item.countOfCreatedTicketsWithTypeError.toString()
            it.other.text = item.countOfTicketsWithOtherTypes.toString()
            it.total.text = item.countOfCreatedTickets.toString()
            it.done.text = item.countOfClosedTicketsInThisMonth.toString()
            it.difference.text = item.difference.toString()
            onClick(it.bugCard, 0, position)
            onClick(it.otherCard, 1, position)
            onClick(it.totalCard, 2, position)
            onClick(it.doneCard, 3, position)
            onClick(it.differenceCard, 4, position)

            if (positions == position) {
                when (index) {
                    0 -> { changeColor(it.bugCard, "#EC5555",cards)}
                    1 -> { changeColor(it.otherCard, "#96CCE4",cards)}
                    2 -> { changeColor(it.totalCard,  "#FFC869",cards)}
                    3 -> { changeColor(it.doneCard,"#84CD78",cards)}
                    4 -> { changeColor(it.differenceCard,  "#4560FF",cards)}
                }
            } else {
                for (i in cards) {
                    i.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                }
            }
        }
        }
    override fun getItemCount(): Int {
      return list.size
    }
    fun getMonth(position: Int):String {
        return list[position].nameOfMonth
    }

    private fun changeColor(card:CardView, color:String, cards:List<CardView>){
        card.setCardBackgroundColor(Color.parseColor(color))
        for (i in cards.filter { it != card }) {
            i.setCardBackgroundColor(Color.WHITE)
        }
    }
}