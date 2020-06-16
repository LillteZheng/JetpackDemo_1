package com.zhengsr.jetpackdemo.entity.room

import androidx.room.*
import com.zhengsr.jetpackdemo.entity.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user:User) : Long

    @Update
    fun updateUser(user: User)

    @Delete
    fun  deleteUser(user: User)

    @Query("delete from User where lastName = :lastName")
    fun deleteByLastName(lastName:String) :Int

    @Query("select * from User")
    fun loadAllUsers():List<User>

    @Query("select * from User where age > :age")
    fun loadUserOlderThanAge(age:Int) : User
}