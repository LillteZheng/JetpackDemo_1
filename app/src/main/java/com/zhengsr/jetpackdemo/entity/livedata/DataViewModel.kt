package com.zhengsr.jetpackdemo.entity.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author by zhengshaorui on 2020/6/12
 * Describe:
 */
class DataViewModel() :ViewModel() {

    private val _counter = MutableLiveData<Int>()

    val counter : LiveData<Int> get() = _counter;
    init {
        _counter.value = 0;
    }
    fun plusOne(){
        val size = _counter.value ?: 0;
        _counter.value = size+1;
    }
}