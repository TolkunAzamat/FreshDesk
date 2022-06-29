package com.example.freshdesk.adapters
import android.content.Context
import android.widget.TextView
import com.example.freshdesk.R
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF


class MarkerAdapter(context: Context?, layoutResource: Int, private val nameMonth: String) :
    MarkerView(context, layoutResource) {
    private val month = findViewById<TextView>(R.id.month)
    private val n = findViewById<TextView>(R.id.number)
    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if (highlight != null) {
            n.text = e?.y?.toInt().toString()
            month.text = nameMonth
        }
    }

    override fun getOffset(): MPPointF {
        return MPPointF(-width / 2f, -height.toFloat())
    }
}