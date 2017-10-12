package com.abdulrahmanjavanrd.prioritytaskdemo5.services

import android.app.IntentService
import android.content.Intent
import android.os.IBinder

/**
 * Created by nfs05 on 12/10/2017.
 */
class MyService : IntentService("Worker Thread "){

    override fun onCreate() {
        super.onCreate()
    }
    override fun onBind(intent: Intent?): IBinder {
        return super.onBind(intent)
    }
    override fun onHandleIntent(p0: Intent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}