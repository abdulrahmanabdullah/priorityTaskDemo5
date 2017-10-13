package com.abdulrahmanjavanrd.prioritytaskdemo5.services

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Created by nfs05 on 13/10/2017.
 */
class TaskService : Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var totalTime:Int = intent!!.getIntExtra("time",5)
        TaskSync(this).execute(totalTime)
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
    override fun onDestroy() {
        super.onDestroy()
    }
}