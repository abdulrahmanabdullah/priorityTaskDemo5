package com.abdulrahmanjavanrd.prioritytaskdemo5.services

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast

/**
 * Created by nfs05 on 13/10/2017.
 */
class TaskSync(context:Context) : AsyncTask<Int,String,Int?>(){

    var context:Context?=null
    init {
        this.context = context
    }

private val TAG = TaskSync::class.java.simpleName
    override fun onPreExecute() {
        Log.i(TAG,"onPreExecute , Thread = ${Thread.currentThread().name}")
        super.onPreExecute()
    }

    override fun onProgressUpdate(vararg values: String?) {

        Log.i(TAG,"onProgressUpdate  ${values[0]}, Thread = ${Thread.currentThread().name}")
        super.onProgressUpdate(*values)
    }
    override fun doInBackground(vararg p0: Int?): Int? {
        var t1:Int = p0[0]!!.toInt()
//        var ctr =1
        //
        while (t1 >= 0){
            Thread.sleep(1000)
            publishProgress("$t1")
            t1 -=1
        }

        Log.i(TAG,"doInBackGround , Thread = ${Thread.currentThread().name}")
        return t1
    }


    override fun onPostExecute(result: Int?) {
        Log.i(TAG,"onPostExecute ., Thread = ${Thread.currentThread().name}")
        super.onPostExecute(result)
        var intent = Intent("action.service.to.fragTask")
        intent.putExtra("receiver","$result")
        context!!.sendBroadcast(intent)
    }
}