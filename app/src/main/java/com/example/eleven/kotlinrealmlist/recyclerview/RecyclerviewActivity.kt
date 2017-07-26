package com.example.eleven.kotlinrealmlist.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.eleven.kotlinrealmlist.DataHelper

import com.example.eleven.kotlinrealmlist.R
import com.example.eleven.kotlinrealmlist.model.Animal
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlin.properties.Delegates

class RecyclerviewActivity : AppCompatActivity() {

    private var realm: Realm by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        Realm.init(this)
        realm = Realm.getDefaultInstance()
        var helper: DataHelper = DataHelper()
        helper.addItemAsync(realm, addDataToAnimals())
        recyclerview_realm.layoutManager = LinearLayoutManager(this)
        recyclerview_realm.hasFixedSize()
        recyclerview_realm.adapter = RecyclerviewAdapter(realm.where(Animal::class.java).findAll(), true)

    }

    override fun onDestroy() {
        super.onDestroy()
        recyclerview_realm.adapter = null
        realm.close()
    }

    fun addDataToAnimals() : Animal{
        var animal1 = Animal(1, "Cholo")
        animal1.animalAge = 4
        animal1.animalType = "Dog"
        return animal1
    }
}
