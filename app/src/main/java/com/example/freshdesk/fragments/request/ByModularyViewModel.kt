package com.example.freshdesk.fragments.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshdesk.api.models.ReportModularly
import com.example.freshdesk.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ByModularyViewModel : ViewModel() {
    private val repository = MainRepository()
    var list: MutableLiveData<List<ReportModularly>> = MutableLiveData()
    fun modularlyReports(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.modularlyReports().let {
                if(it.isSuccessful)
                    list.postValue(it.body())
            }
        }
    }
}