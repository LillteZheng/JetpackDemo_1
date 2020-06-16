package com.zhengsr.jetpackdemo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author by zhengshaorui on 2020/6/13
 * Describe:
 */
@Entity
data class User (var firstName:String,var lastName:String,var age:Int){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}