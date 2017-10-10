package com.abdulrahmanjavanrd.prioritytaskdemo5.fragments

import android.app.Fragment
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

    var sp_numbers:Spinner?=null
    var sp_date :Spinner ? =null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v:View = inflater!!.inflate(R.layout.frag_task_layout,container,false)
        task = v.findViewById(R.id.task_type)
        task!!.text = itemOne[0]
        sp_numbers = v.findViewById(R.id.sp_numbers)
        sp_date = v.findViewById(R.id.sp_date)
        takeNumbers()
        return v
    }

    //spinner extension
    private fun Spinner.mySelectedItemd(listene: AdapterView.OnItemSelectedListener){
        onItemSelectedListener = listene
    }
    var i:Int = 0
   private fun takeNumbers(){
        sp_numbers!!.mySelectedItemd(object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when(p0!!.getItemAtPosition(p2!!)){
                    0->{i++ }
                    1->{i+= 2 }
                }
                Log.i(TAG,"your choice $i")
            }


            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        sp_date!!.mySelectedItemd(object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Log.i(TAG,"And you take :  ${p0!!.getItemAtPosition(p2!!)}")
            }


            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }



}