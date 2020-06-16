package com.zhengsr.jetpackdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.zhengsr.jetpackdemo.R
import com.zhengsr.jetpackdemo.entity.User
import com.zhengsr.jetpackdemo.entity.room.AppDataBase
import kotlinx.android.synthetic.main.activity_room.*
import java.time.Year
import kotlin.concurrent.thread

class RoomActivity : AppCompatActivity() {
    private  val TAG = "RoomActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val userDao = AppDataBase.getDatabase(this).userDao();
        val user1 = User("z","sr",23)
        val user2 = User("w","y",23)




        addDataBtn.setOnClickListener{
            thread {
                userDao.insertUser(user1)
                userDao.insertUser(user2)
            }
        }

        updateBtn.setOnClickListener{
            thread {
                 user1.age = 26
                 userDao.updateUser(user1)
            }
        }

        deleteBtn.setOnClickListener{
            thread {
                userDao.deleteByLastName("y");
            }
        }

        queryBtn.setOnClickListener{
            thread {
                for (user in userDao.loadAllUsers()){
                    Log.d(TAG, "zsr onCreate: "+user.toString())
                }
            }
        }
    }
}