package com.abdulrahmanjavanrd.prioritytaskdemo5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set toolbar ..
        setSupportActionBar(toolbar_layout)

        // set drawer
        var toggle = ActionBarDrawerToggle(
                this,drawer_home,toolbar_layout,R.string.nav_open,R.string.nav_close)
        drawer_home.addDrawerListener(toggle)
        nav_layout.setNavigationItemSelectedListener (this)
        toggle.syncState()


        /** call fragments method **/
        /** end call fragments methods **/
    }

    /** navigation */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.drawer_home_list->{}
            R.id.drawer_process->{}
            R.id.sync_process->{}
            R.id.done_process->{}
            R.id.exit->{
                finish()
            }
            else->{}
        }

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.setting_button->{
                Toast.makeText(this,"selected setting",Toast.LENGTH_LONG).show()
            }

            else ->{}
        }
        return true
    }
}
