package com.abdulrahmanjavanrd.prioritytaskdemo5.services

import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.os.ResultReceiver

/**
 * Created by nfs05 on 12/10/2017.
 */
class MyService : IntentService("Worker Thread "){

    private val TAG = MyService::class.java.simpleName
    override fun onCreate() {
        super.onCreate()
    }
    override fun onBind(intent: Intent?): IBinder {
        return super.onBind(intent)
    }
    override fun onHandleIntent(p0: Intent?) {
        var receiver:ResultReceiver = p0!!.getParcelableExtra("sendReceiver")
        var t1 = p0!!.getIntExtra("totalTime",10)
        var bundle = Bundle()
        var ctr = 1
        while (ctr <= 10){
            Thread.sleep(1000)
            bundle.putString("result","$ctr")
            receiver.send(1,bundle)
            ctr++
        }


    }


}