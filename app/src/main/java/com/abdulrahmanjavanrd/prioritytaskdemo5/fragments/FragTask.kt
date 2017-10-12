package com.abdulrahmanjavanrd.prioritytaskdemo5.fragments

import android.app.Fragment
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.abdulrahmanjavanrd.prioritytaskdemo5.R
import com.abdulrahmanjavanrd.prioritytaskdemo5.constants.MyListPriority
import kotlinx.android.synthetic.main.frag_task_layout.*

/**
 * Created by nfs05 on 10/10/2017.
 */
class FragTask : Fragment(){

    //TAG
    private val TAG = FragTask::class.java.simpleName
    var myList = MyListPriority()
    var itemOne:ArrayList<String> = myList.list

    var task:TextView?=null
    var txvTimer:TextView?=null
    var sp_numbers:Spinner?=null
    var sp_date :Spinner ? =null

    var i:Int = 0
    var d:Int =0


    // calculator hours and day and month, than save inside this pram ... totalTime .
    var totalTime:Int ? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var v:View = inflater!!.inflate(R.layout.frag_task_layout,container,false)
        task = v.findViewById(R.id.task_type)
        task!!.text = itemOne[0]
        txvTimer = v.findViewById(R.id.txvTimer)
        sp_numbers = v.findViewById(R.id.sp_numbers)
        sp_date = v.findViewById(R.id.sp_date)
        takeNumbers()
        return v
    }

    //spinner extension
    private fun Spinner.mySelectedItemd(listene: AdapterView.OnItemSelectedListener){
        onItemSelectedListener = listene
    }
   private fun takeNumbers(){
        sp_numbers!!.mySelectedItemd(object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            i = p0!!.getItemIdAtPosition(p2!!).toInt()-1
                totalTime =  getI(i,0)
                txvTimer!!.text = "$totalTime"
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        })
        sp_date!!.mySelectedItemd(object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                d = p0!!.getItemIdAtPosition(p2!!).toInt()
               totalTime =  getI(i,d)
                txvTimer!!.text = "$totalTime"
                Log.i(TAG,"And you take :  ${d}")

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                getI(0,0)
            }

        })
    }

    private fun getI(i:Int,d:Int):Int{
        var result:Int= 0
        if (d != 0 ){
            when(d){
                1 -> { result =  i * 60  }
                2 -> {result =i * 1440 }
                3-> {result = i * 30 }
                else ->{

                }
            }
        }
        else {
            result = i * 1
        }
        Log.i(TAG," Now result  = $result ")
        Log.i(TAG," total Time = $totalTime")
       return result
    }

    /************** BroadcastReceiver Inner class *******************/
    public inner class MyBroadcast:BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
    /************** end  BroadcastReceiver Inner class *******************/


}