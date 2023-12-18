package com.example.appghichu.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appfoodt3h.base.BaseViewModel

class FragmentHomeViewModel:BaseViewModel() {
    private val _noteData = MutableLiveData<String>()
    val noteData: LiveData<String> get() = _noteData

    fun setNoteData(data: String) {
        _noteData.value = data
    }
}