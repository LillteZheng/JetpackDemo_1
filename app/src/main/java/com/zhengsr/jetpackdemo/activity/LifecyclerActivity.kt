package com.zhengsr.jetpackdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zhengsr.jetpackdemo.R
import com.zhengsr.jetpackdemo.entity.lifycycler.MyObserver

class LifecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycler)

       lifecycle.addObserver(MyObserver(lifecycle))

    }
}