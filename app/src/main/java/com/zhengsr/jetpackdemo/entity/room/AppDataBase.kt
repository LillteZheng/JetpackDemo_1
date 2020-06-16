package com.zhengsr.jetpackdemo.entity.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zhengsr.jetpackdemo.entity.User

@Database(version = 3, entities = [UserData::class, Book::class])
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao

    companion object {
        val Migration1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("create table Book (id integer primary key autoincrement not null," +
                        "name text not null ,pages integer not null)")
            }
        }

        val Migration2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table Book add column author text not null default 'unknown'")
            }
        }
        private var instance: AppDataBase? = null;

        @Synchronized
        fun getDatabase(context: Context): AppDataBase {
            instance?.let {
                return it
            }


            val db = Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java, "AppDataBase"
            ).addMigrations(Migration1_2,Migration2_3).build()
            return db.apply {
                instance = this;
            }
        }
    }
}