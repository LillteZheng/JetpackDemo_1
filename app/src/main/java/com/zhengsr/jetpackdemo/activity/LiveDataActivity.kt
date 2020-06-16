package com.zhengsr.jetpackdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zhengsr.jetpackdemo.R
import com.zhengsr.jetpackdemo.entity.User
import com.zhengsr.jetpackdemo.entity.livedata.DataViewModel
import com.zhengsr.jetpackdemo.entity.livedata.UserViewModel
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {
    private  val TAG = "LiveDataActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

       /* val viewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        plusOne.setOnClickListener{
            //点击增加
            viewModel.plusOne()
        }
        //添加数据观察者
        val textObserver = Observer<Int> { count ->
            infoText.text = count.toString()
        }
        viewModel.counter.observe(this,textObserver)*/


        val viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        plusOne.setOnClickListener{
            val name = (0..100).random().toString()
            viewModel.getUser(name)
        }

        viewModel.user.observe(this, Observer { user ->
            infoText.text = user.firstName
            setResult(1)
            finish()
        })
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "zsr onRestart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "zsr onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "zsr onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "zsr onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "zsr onDestroy: ")
    }
}