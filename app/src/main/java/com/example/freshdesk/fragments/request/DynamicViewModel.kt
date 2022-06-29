package com.example.freshdesk.fragments.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freshdesk.api.models.ReportInDynamic
import com.example.freshdesk.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DynamicViewModel : ViewModel() {
    private val repository = MainRepository()
    var list: MutableLiveData<List<ReportInDynamic>> = MutableLiveData()

    fun reportInDynamic(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.dynamicReport().let {
                if(it.isSuccessful)
                    list.postValue(it.body())
            }
        }
    }
}