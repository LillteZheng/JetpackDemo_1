package com.zhengsr.jetpackdemo.entity.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zhengsr.jetpackdemo.entity.User

/**
 * @author by zhengshaorui on 2020/6/13
 * Describe:
 */
object Repository {
    fun getUser(name:String):LiveData<User>{
        val liveData = MutableLiveData<User>()
        liveData.value = User(name,name,0)
        return liveData;
    }
}