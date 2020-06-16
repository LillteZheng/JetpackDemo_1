package com.zhengsr.jetpackdemo.entity.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zhengsr.jetpackdemo.entity.User

@Database(version = 1,entities = [User::class])
abstract class AppDataBase : RoomDatabase(){
    abstract fun userDao() : UserDao;

    companion object{
        private var instance : AppDataBase ? = null;
        @Synchronized
        fun getDatabase(context:Context) : AppDataBase{
            instance?.let {
                return it
            }

            return Room.databaseBuilder(context.applicationContext,
                AppDataBase::class.java,"appdatabase").build().apply {
                instance = this;
            }
        }
    }
}