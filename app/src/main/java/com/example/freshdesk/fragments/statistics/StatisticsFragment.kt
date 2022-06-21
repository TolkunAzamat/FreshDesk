package com.example.freshdesk.fragments.statistics

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.freshdesk.R
import com.example.freshdesk.adapters.MonthStatisticsAdapter
import com.example.freshdesk.api.models.ReportMonthlyItem
import com.example.freshdesk.databinding.FragmentByClientsBinding
import com.example.freshdesk.databinding.FragmentReportsBinding
import com.example.freshdesk.databinding.FragmentStatisticsBinding
import com.example.freshdesk.fragments.report.ReportsViewModel
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.util.ArrayList

class StatisticsFragment : Fragment(){
    private lateinit var databinding:FragmentStatisticsBinding
    private val viewModel by lazy { StatisticsViewModel() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        databinding= FragmentStatisticsBinding.inflate(inflater,container,false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text="Статистика"
        setadapter()
    }
    fun setadapter(){
        viewModel.list.observe(viewLifecycleOwner){
            databinding.recyclerMonth.adapter = MonthStatisticsAdapter(it)
            it?.let { it1 -> setLineChart(databinding.lineChart, it1) }

        }
    }
    fun setLineChart(lineChart: LineChart, response: List<ReportMonthlyItem>) {

        val statisticsMonthly = ArrayList<String>()
        val statisticsError = ArrayList<Entry>()
        val statisticsOther = ArrayList<Entry>()
        val statisticsTotal = ArrayList<Entry>()
        val statisticsClosed = ArrayList<Entry>()
        val statisticsDifference = ArrayList<Entry>()

        for (i in response.indices) {
            val month = response[i].nameOfMonth
            val error = response[i].countOfCreatedTicketsWithTypeError
            val other = response[i].countOfTicketsWithOtherTypes
            val total = response[i].countOfCreatedTickets
            val closed = response[i].countOfClosedTicketsInThisMonth
            val difference = response[i].difference

            statisticsMonthly.add(month)
            statisticsError.add(Entry(i.toFloat(), error.toFloat()))
            statisticsOther.add(Entry(i.toFloat(), other.toFloat()))
            statisticsTotal.add(Entry(i.toFloat(), total.toFloat()))
            statisticsClosed.add(Entry(i.toFloat(), closed.toFloat()))
            statisticsDifference.add(Entry(i.toFloat(), difference.toFloat()))
        }

        val error = LineDataSet(statisticsError, "Error")
        val other = LineDataSet(statisticsOther, "other")
        val total = LineDataSet(statisticsTotal, "total")
        val closed = LineDataSet(statisticsClosed, "closed")
        val difference = LineDataSet(statisticsDifference, "difference")

        error.apply {
            lineWidth = 2f
            color = Color.parseColor("#EC5555")
            setDrawCircles(true)
            setDrawCircleHole(true)
            setCircleColor(Color.parseColor("#EC5555"))
            circleHoleColor = Color.parseColor("#FFFFFF")
            circleRadius = 5f
            circleHoleRadius = 3f
        }

        other.apply {
            lineWidth = 2f
            color = Color.parseColor("#96CCE4")
            setDrawCircles(true)
            setDrawCircleHole(true)
            setCircleColor(Color.parseColor("#96CCE4"))
            circleHoleColor = Color.parseColor("#FFFFFF")
            circleRadius = 5f
            circleHoleRadius = 3f
        }

        total.apply {
            lineWidth = 2f
            color = Color.parseColor("#FFC869")
            setDrawCircles(true)
            setDrawCircleHole(true)
            setCircleColor(Color.parseColor("#FFC869"))
            circleHoleColor = Color.parseColor("#FFFFFF")
            circleRadius = 5f
            circleHoleRadius = 3f
        }

        closed.apply {
            lineWidth = 2f
            color = Color.parseColor("#84CD78")
            setDrawCircles(true)
            setDrawCircleHole(true)
            setCircleColor(Color.parseColor("#84CD78"))
            circleHoleColor = Color.parseColor("#FFFFFF")
            circleRadius = 5f
            circleHoleRadius = 3f
        }

        difference.apply {
            lineWidth = 2f
            color = Color.parseColor("#4560FF")
            setDrawCircles(true)
            setDrawCircleHole(true)
            setCircleColor(Color.parseColor("#4560FF"))
            circleHoleColor = Color.parseColor("#FFFFFF")
            circleRadius = 5f
            circleHoleRadius = 3f
        }

        val dataSets: ArrayList<ILineDataSet> = ArrayList()

        dataSets.clear()
        dataSets.let {
            it.add(error)
            it.add(other)
            it.add(total)
            it.add(closed)
            it.add(difference)
        }

        lineChart.xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            granularity = 1f
            labelRotationAngle = 0f
            valueFormatter = IndexAxisValueFormatter(statisticsMonthly)
            isEnabled = true
        }

        lineChart.apply {
            setTouchEnabled(true)
            description.isEnabled = false
            legend.isEnabled = false
            animateY(1400, Easing.EaseInSine)
        }

        val data = LineData(dataSets)
        lineChart.data = data
        lineChart.notifyDataSetChanged()
        lineChart.invalidate()
    }}
