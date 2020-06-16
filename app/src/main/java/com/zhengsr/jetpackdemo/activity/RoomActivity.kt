package com.zhengsr.jetpackdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.zhengsr.jetpackdemo.R
import com.zhengsr.jetpackdemo.entity.room.AppDataBase
import com.zhengsr.jetpackdemo.entity.room.Book
import com.zhengsr.jetpackdemo.entity.room.UserData
import kotlinx.android.synthetic.main.activity_room.*
import java.time.Year
import kotlin.concurrent.thread

class RoomActivity : AppCompatActivity() {
    private  val TAG = "RoomActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val userDao = AppDataBase.getDatabase(this).userDao();
        val user1 = UserData(1,"z","sr")
        val user2 = UserData(2,"w","y")

        val bookDao = AppDataBase.getDatabase(this).bookDao()

        //添加数据
        addDataBtn.setOnClickListener{
            thread {
                userDao.insertAll(user1,user2)
                 bookDao.insertBook(Book("android",100))
            }
        }
        //更新数据
        updateBtn.setOnClickListener{
            thread {
                 user2.lastName = "san"
                 userDao.updateUser(user2)

            }
        }

        //删除
        deleteBtn.setOnClickListener{
            thread {
               // userDao.delete(user1)
                userDao.deleteByLastName("sr")
            }
        }

        //查询
        queryBtn.setOnClickListener{
            thread {
                for (user in userDao.getAll()){
                    Log.d(TAG, "zsr onCreate: "+user.toString())
                }
                for (book in bookDao.loadAllBooks()){
                    Log.d(TAG, "zsr onCreate: "+book.toString())
                }
            }
        }
    }
}