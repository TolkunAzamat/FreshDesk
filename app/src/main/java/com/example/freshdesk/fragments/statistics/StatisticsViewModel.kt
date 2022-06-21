package com.example.freshdesk.fragments.statistics

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshdesk.api.models.ReportBreakDownByTicketsTypeReport
import com.example.freshdesk.api.models.ReportMonthly
import com.example.freshdesk.api.models.ReportMonthlyItem
import com.example.freshdesk.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StatisticsViewModel: ViewModel() {

    private val repository = MainRepository()
    var list=MutableLiveData<List<ReportMonthlyItem>>()
    init {
        monthlystatistic()
    }
    fun monthlystatistic() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.monthlyStatistics().let {
                if(it.isSuccessful)
                    list.postValue(it.body())
            }
        }
    }
}