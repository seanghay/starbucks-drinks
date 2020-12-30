package com.seanghay.starbucksdrinks.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.seanghay.resultof.resultOf
import com.seanghay.starbucksdrinks.http.menuService
import kotlinx.coroutines.Dispatchers

class MenuViewModel : ViewModel() {

    val categories = liveData(Dispatchers.IO) {
        emit(resultOf {
            menuService.menu()
        })
    }


}