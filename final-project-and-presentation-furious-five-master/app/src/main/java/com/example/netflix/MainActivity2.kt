package com.example.netflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle




class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val peopleFragment =  this.supportFragmentManager.findFragmentById(R.id.fragment_persons)
        if( peopleFragment == null){

            val fragment = PeopleFragment()
            this.supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_persons, fragment)
                .commit()
        }


    }
}