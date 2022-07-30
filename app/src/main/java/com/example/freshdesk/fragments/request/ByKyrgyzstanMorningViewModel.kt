package com.example.freshdesk.fragments.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshdesk.api.models.ReportByAgents
import com.example.freshdesk.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ByKyrgyzstanMorningViewModel : ViewModel() {
    private val repository = MainRepository()
    var list: MutableLiveData<List<ReportByAgents>> = MutableLiveData()

    fun agentsReport() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.agentsReports().let {
                if (it.isSuccessful)
                    list.postValue(it.body())
            }
        }
    }
}