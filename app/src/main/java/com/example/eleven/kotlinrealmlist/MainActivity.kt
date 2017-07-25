package com.example.eleven.kotlinrealmlist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.eleven.kotlinrealmlist.listview.ListviewActivity
import com.example.eleven.kotlinrealmlist.recyclerview.RecyclerviewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    override fun onClick(ID: View?) {
        when(ID){
            btnListview -> proceedToChosenActivity(ListviewActivity::class.java)
            btnRecyclerview -> proceedToChosenActivity(RecyclerviewActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRecyclerview.setOnClickListener(this)
        btnListview.setOnClickListener(this)
    }

    fun proceedToChosenActivity(destinationActivity: Class<out Activity>){
        startActivity(Intent(this, destinationActivity))
    }

}
