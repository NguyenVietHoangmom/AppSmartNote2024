package com.example.appsmartnote2024.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SharedViewModel {
    private val _noteData = MutableLiveData<String>()
    val noteData: LiveData<String> get() = _noteData

    fun setNoteData(data: String) {
        _noteData.value = data
    }
}