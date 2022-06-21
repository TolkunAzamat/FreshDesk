package com.example.freshdesk.fragments.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshdesk.api.models.ReportClientAndModuleItem
import com.example.freshdesk.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ByClientsViewModel:ViewModel() {
    private val repository = MainRepository()
    var list: MutableLiveData<List<ReportClientAndModuleItem>> = MutableLiveData()
    init {
        clientAndModule()
    }

    fun clientAndModule(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.clientAndModule().let {
                if(it.isSuccessful)
                    list.postValue(it.body())
            }
        }
    }
}