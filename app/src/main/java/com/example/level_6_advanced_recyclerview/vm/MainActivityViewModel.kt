package com.example.level_6_advanced_recyclerview.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.level_6_advanced_recyclerview.model.ColorItem
import com.example.level_6_advanced_recyclerview.repo.ColorRepository

class MainActivityViewModel : ViewModel(){

    private val colorRepository = ColorRepository()

    val colorItems = MutableLiveData<List<ColorItem>>().apply {
        value = colorRepository.getColorItems()
    }
}
