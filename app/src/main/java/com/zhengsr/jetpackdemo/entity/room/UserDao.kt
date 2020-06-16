package com.zhengsr.jetpackdemo.entity.room

import androidx.room.*

@Dao
interface UserDao {



    @Query("SELECT * FROM userdata")
    fun getAll(): List<UserData>

    @Update
    fun updateUser(user: UserData)

    @Query("SELECT * FROM userdata WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): UserData

    @Insert
    fun insertAll(vararg users: UserData)

    @Delete
    fun delete(user: UserData)

    @Query("delete from UserData where last_name = :lastName")
    fun deleteByLastName(lastName:String) :Int
}