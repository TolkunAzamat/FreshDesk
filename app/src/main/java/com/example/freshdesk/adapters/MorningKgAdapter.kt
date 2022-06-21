package com.example.freshdesk.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshdesk.api.models.ReportByAgentsItem
import com.example.freshdesk.databinding.ItemMorningKgBinding

class MorningKgAdapter(private val list: List<ReportByAgentsItem>): RecyclerView.Adapter<MorningKgAdapter.ViewHolder>() {
    class ViewHolder(val databinding: ItemMorningKgBinding) :
        RecyclerView.ViewHolder(databinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMorningKgBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.databinding.let {
            it.agent.text = item.name
            it.openlyGet.text = item.openGet.toString()
            it.openlySet.text = item.openSet.toString()
            it.openlyStatic.text = item.openStatic.toString()
            it.pendingGet.text = item.awaitGet.toString()
            it.pendingSet.text = item.awaitSet.toString()
            it.pendingStatic.text = item.awaitStatic.toString()
            it.awaitingEvaluationGet.text = item.awaitingEvaluationGet.toString()
            it.awaitingEvaluationSet.text = item.awaitingEvaluationSet.toString()
            it.evaluationInProgressGet.text = item.assessmentInProgressGet.toString()
            it.evaluationInProgressSet.text = item.assessmentInProgressSet.toString()
            it.ratingSentGet.text = item.assessmentSentGet.toString()
            it.ratingSentSet.text = item.assessmentSentSet.toString()
            it.refusalGet.text = item.reject.toString()
            it.confirmedGet.text = item.orderConfirmedGet.toString()
            it.confirmedSet.text = item.orderConfirmedSet.toString()
            it.inProgressGet.text = item.inWorkGet.toString()
            it.inProgressGet.text = item.inWorkSet.toString()
            it.onTestingGet.text = item.submittedForVerificationGet.toString()
            it.onTestingSet.text = item.submittedForVerificationSet.toString()
            it.feedbackGet.text = item.feedbackFromTheClientGet.toString()
            it.feedbackSet.text = item.feedbackFromTheClientSet.toString()
            it.queueGet.text = item.inTheQueueForDeliveryGet.toString()
            it.queueSet.text = item.inTheQueueForDeliverySet.toString()
            it.closedGet.text = item.closed.toString()
        }
        if (position % 2 == 0) {
            holder.databinding.let {
                it.agent.setBackgroundColor(Color.parseColor("#DBDBDB"))
                it.openlySet.setBackgroundColor(Color.parseColor("#DBDBDB"))
                it.pendingGet.setBackgroundColor(Color.parseColor("#DBDBDB"))
                it.pendingStatic.setBackgroundColor(Color.parseColor("#DBDBDB"))
                it.awaitingEvaluationSet.setBackgroundColor(Color.parseColor("#DBDBDB"))
                it.evaluationInProgressSet.setBackgroundColor(Color.parseColor("#DBDBDB"))
                it.ratingSentSet.setBackgroundColor(Color.parseColor("#DBDBDB"))
                it.confirmedGet.setBackgroundColor(Color.parseColor("#DBDBDB"))
                it.inProgressGet.setBackgroundColor(Color.parseColor("#DBDBDB"))


            }
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
}