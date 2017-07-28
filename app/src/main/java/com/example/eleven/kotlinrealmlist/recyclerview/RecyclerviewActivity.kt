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
        helper.addItemAsync(realm, addDataToAnimals2())
        helper.addItemAsync(realm, addDataToAnimals3())
        helper.addItemAsync(realm, addDataToAnimals4())

        recyclerview_realm.layoutManager = LinearLayoutManager(this)
        recyclerview_realm.hasFixedSize()
        recyclerview_realm.adapter = RecyclerviewAdapter(realm.where(Animal::class.java).findAll(), true)
    }

    fun deleteDataFromRealm(){
        realm.executeTransaction { realm.deleteAll() }
    }

    override fun onDestroy() {
        super.onDestroy()
        recyclerview_realm.adapter = null
        realm.close()
    }

    fun addDataToAnimals() : Animal{
        var animal1 = Animal("Cholo", 4, "Dog")
        return animal1
    }

    fun addDataToAnimals2() : Animal{
        var animal1 = Animal("Choy", 1, "Horse")
        return animal1
    }

    fun addDataToAnimals3() : Animal{
        var animal1 = Animal("Muning", 400, "Cat")
        return animal1
    }

    fun addDataToAnimals4() : Animal{
        var animal1 = Animal("Katie", 7, "Dog")
        return animal1
    }
}
