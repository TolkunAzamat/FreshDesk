package com.example.freshdesk.fragments.statistics

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.freshdesk.R
import com.example.freshdesk.adapters.MarkerAdapter
import com.example.freshdesk.adapters.MonthStatisticsAdapter
import com.example.freshdesk.api.models.ReportMonthly
import com.example.freshdesk.databinding.FragmentStatisticsBinding
import com.example.freshdesk.utils.alertDialog
import com.example.freshdesk.utils.isNetworkConnected
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class StatisticsFragment : Fragment(){
    private lateinit var databinding:FragmentStatisticsBinding
    private val viewModel by lazy { StatisticsViewModel() }
    private val adapter by lazy { MonthStatisticsAdapter() }
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

        databinding.toolbar.exit.setOnClickListener {
            alertDialog(requireContext())}
        setClicks()
        checkInternet()

    }
    private fun setAdapter(){
        viewModel.list.observe(viewLifecycleOwner){
            adapter.setList(it)
            databinding.recyclerMonth.adapter= adapter
            it?.let { it1 -> setLineChart(databinding.lineChart, it1) }
        }
        adapter.setLine(databinding.lineChart)
    }

    private fun setClicks() {
        databinding.lineChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                databinding.lineChart.marker = MarkerAdapter(requireContext(), R.layout.markerview, adapter.getMonth(e?.x?.toInt()!!))
                adapter.setPos(e?.x?.toInt(),h?.dataSetIndex)
                adapter.notifyDataSetChanged()
            }

            override fun onNothingSelected() {
            }
        })
    }
   private fun setLineChart(lineChart: LineChart, response: List<ReportMonthly>) {
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
            setColor(Color.parseColor("#EC5555"))
            setDrawCircles(true)
            setDrawCircleHole(true)
            setCircleColor(Color.parseColor("#EC5555"))
            circleHoleColor = Color.parseColor("#FFFFFF")
            circleRadius = 8f
            circleHoleRadius = 6f
        }

        other.apply {
            lineWidth = 2f
            color = Color.parseColor("#96CCE4")
            setDrawCircles(true)
            setDrawCircleHole(true)
            setCircleColor(Color.parseColor("#96CCE4"))
            circleHoleColor = Color.parseColor("#FFFFFF")
            circleRadius = 8f
            circleHoleRadius = 6f
        }

        total.apply {
            lineWidth = 2f
            color = Color.parseColor("#FFC869")
            setDrawCircles(true)
            setDrawCircleHole(true)
            setCircleColor(Color.parseColor("#FFC869"))
            circleHoleColor = Color.parseColor("#FFFFFF")
            circleRadius = 8f
            circleHoleRadius = 6f
        }

        closed.apply {
            lineWidth = 2f
            color = Color.parseColor("#84CD78")
            setDrawCircles(true)
            setDrawCircleHole(true)
            setCircleColor(Color.parseColor("#84CD78"))
            circleHoleColor = Color.parseColor("#FFFFFF")
            circleRadius = 8f
            circleHoleRadius = 6f
        }

        difference.apply {
            lineWidth = 2f
            color = Color.parseColor("#4560FF")
            setDrawCircles(true)
            setDrawCircleHole(true)
            setCircleColor(Color.parseColor("#4560FF"))
            circleHoleColor = Color.parseColor("#FFFFFF")
            circleRadius = 8f
            circleHoleRadius = 6f
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
            isEnabled = false
        }

        lineChart.apply {
            setTouchEnabled(true)
            description.isEnabled = false
            legend.isEnabled = false
            animateY(1400, Easing.EaseInOutElastic)
        }

        val data = LineData(dataSets)
        lineChart.data = data
        lineChart.notifyDataSetChanged()
        lineChart.invalidate()
    }
    private fun checkInternet() {
        if (isNetworkConnected(requireContext())) {
            viewModel.monthlyStatistics()
            setAdapter()
        } else Toast.makeText(requireContext(),
            "Отсутсвует подключение к интернету",
            Toast.LENGTH_SHORT).show()
    }
}
