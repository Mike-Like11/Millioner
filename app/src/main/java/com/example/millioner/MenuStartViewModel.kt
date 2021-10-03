package com.example.millioner

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MenuStartViewModel(application: Application): AndroidViewModel(application) {
    private var db: MillionerDatabase? = MillionerDatabase.getInstance(context = application)
    private var testDao:TestDao? = null
    fun insert(test:Test){
        viewModelScope.launch(Dispatchers.IO) {
            db?.testDao()?.insert(test)
        }
    }

}