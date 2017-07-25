package com.example.eleven.kotlinrealmlist.model

import io.realm.RealmObject

/**
 * Created by ELEVEN on 7/25/2017.
 */

open class Animal : RealmObject(){
    var animalName: String? = null
    var animalAge: Int? = null
    var animalType: String? = null
}
