package com.example.freshdesk.fragments.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshdesk.api.models.ReportBreakDownByTicketsTypeReport
import com.example.freshdesk.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReportsViewModel : ViewModel() {
    private val repository = MainRepository()
    var list: MutableLiveData<ReportBreakDownByTicketsTypeReport> = MutableLiveData()
    fun reports() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.breakDnReport().let {
                if (it.isSuccessful)
                    list.postValue(it.body())
            }
        }
    }
}
