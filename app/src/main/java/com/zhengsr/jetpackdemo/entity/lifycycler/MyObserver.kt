package com.zhengsr.jetpackdemo.entity.lifycycler

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author by zhengshaorui on 2020/6/12
 * Describe:
 */
class MyObserver(val lifecycle: Lifecycle) : LifecycleObserver {
    private  val TAG = "MyOberver"
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.d(TAG,"zsr onResume: "+lifecycle.currentState)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        Log.d(TAG, "zsr onPause: ")
    }
}