package com.zhengsr.jetpackdemo.entity.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.zhengsr.jetpackdemo.entity.User

/**
 * @author by zhengshaorui on 2020/6/13
 * Describe:
 */
class UserViewModel : ViewModel() {
    /*private val userLiveData = MutableLiveData<User>()

    val userName:LiveData<String> = Transformations.map(userViewModel){
        user -> "${user.firstName} ${user.lastName}"
    }

    fun getUserName(user: User){
        userViewModel.value = user;
    }*/

    private val userLiveData = MutableLiveData<String>()
    val user : LiveData<User> = Transformations.switchMap(userLiveData){
        name -> Repository.getUser(name)
    }

    fun  getUser(name: String){
        userLiveData.value = name;
    }
}