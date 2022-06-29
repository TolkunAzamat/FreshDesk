package com.example.freshdesk.fragments.report

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.freshdesk.R
import com.example.freshdesk.api.models.ReportBreakDownByTicketsTypeReport
import com.example.freshdesk.databinding.FragmentReportsBinding
import com.example.freshdesk.utils.alertDialog
import com.example.freshdesk.utils.isNetworkConnected
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener


class ReportsFragment : Fragment() {
    private lateinit var databinding: FragmentReportsBinding
    private val viewModel by lazy { ReportsViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        databinding = FragmentReportsBinding.inflate(layoutInflater)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.toolbar.title.text = "Отчеты"
        databinding.toolbar.exit.setOnClickListener {
            alertDialog(requireContext())
        }
        checkInternet()
        onClick()
        onClickPie()
    }


    private fun setData() {
        viewModel.list.observe(viewLifecycleOwner) {
            setPieChart(it, databinding.pieChart)
            databinding.countBug.text = it.errorBugCount.toString()
            databinding.percentBug.text = it.errorBugPercent.toString()
            databinding.changeAmount.text = it.changeRequestCount.toString()
            databinding.percentChange.text = it.changeRequestPercent.toString()
            databinding.questionAmount.text = it.systemQuestionCount.toString()
            databinding.percentQuestion.text = it.systemQuestionPercent.toString()
            databinding.newFunAmount.text = it.newFunctionalityRequestCount.toString()
            databinding.percentNewFun.text = it.newFunctionalityRequestPercent.toString()
            databinding.parameterizationAmount.text = it.parametrizationQuestionCount.toString()
            databinding.percentParameterization.text = it.parametrizationQuestionPercent.toString()
        }
    }

    private fun setPieChart(data: ReportBreakDownByTicketsTypeReport, pieChart: PieChart) {
        val array = ArrayList<PieEntry>()
        val colors = ArrayList<Int>()
        array.add(PieEntry(data.errorBugPercent.toFloat()))
        array.add(PieEntry(data.changeRequestPercent.toFloat()))
        array.add(PieEntry(data.systemQuestionPercent.toFloat()))
        array.add(PieEntry(data.newFunctionalityRequestPercent.toFloat()))
        array.add(PieEntry(data.parametrizationQuestionPercent.toFloat()))
        colors.add(Color.parseColor("#EC5555"))
        colors.add(Color.parseColor("#4560FF"))
        colors.add(Color.parseColor("#FFC869"))
        colors.add(Color.parseColor("#F98F57"))
        colors.add(Color.parseColor("#73C6FF"))
        val set = PieDataSet(array, "")
        set.colors = colors
        set.sliceSpace = 7f
        set.selectionShift = 10f
        val data = PieData(set)
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(pieChart))
        data.setValueTextSize(12f)
        data.setValueTextColor(R.color.black)

        pieChart.setUsePercentValues(true)
        pieChart.centerText = "Разбивка\n по типам\n заявок"
        pieChart.setCenterTextColor(Color.parseColor("#232630"))
        pieChart.setCenterTextSize(18f)

        pieChart.description.isEnabled = false
        pieChart.setTouchEnabled(true)
        pieChart.legend.isEnabled = false
        pieChart.animateY(1400, Easing.EaseInOutQuad)
        pieChart.data = data
        pieChart.invalidate()
    }

    private fun onClick() {
        databinding.bugs.setOnClickListener {
            databinding.pieChart.highlightValue(0f, 0, true)
            changeColor(databinding.bugs)
        }
        databinding.change.setOnClickListener {
            databinding.pieChart.highlightValue(1f, 0, true)
            changeColor(databinding.change)
        }
        databinding.request.setOnClickListener {
            databinding.pieChart.highlightValue(2f, 0, true)
            changeColor(databinding.request)

        }
        databinding.newFun.setOnClickListener {
            databinding.pieChart.highlightValue(3f, 0, true)
            changeColor(databinding.newFun)

        }
        databinding.parametrization.setOnClickListener {
            databinding.pieChart.highlightValue(4f, 0, true)
            changeColor(databinding.parametrization)
        }
    }

    private fun onClickPie() {
        databinding.pieChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                Log.e("TAG", "onValueSelected: ${h?.x}")
                when (h?.x) {
                    0.0f -> changeColor(databinding.bugs)
                    1.0f -> changeColor(databinding.change)
                    2.0f -> changeColor(databinding.request)
                    3.0f -> changeColor(databinding.newFun)
                    4.0f -> changeColor(databinding.parametrization)
                }
            }

            override fun onNothingSelected() {}

        })
    }

    fun changeColor(card: CardView) {
        card.setCardBackgroundColor(Color.parseColor("#E7E7E7"))
        val array = arrayOf(databinding.bugs,
            databinding.change,
            databinding.request,
            databinding.newFun,
            databinding.parametrization)
        for (i in array.filter { it != card }) {
            i.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }

    private fun checkInternet() {
        if (isNetworkConnected(requireContext())) {
            viewModel.reports()
            setData()
        } else Toast.makeText(requireContext(),
            "Отсутсвует подключение к интернету",
            Toast.LENGTH_SHORT).show()
    }
}