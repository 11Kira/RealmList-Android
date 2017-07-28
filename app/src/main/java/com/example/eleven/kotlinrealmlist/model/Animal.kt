package com.example.eleven.kotlinrealmlist.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ELEVEN on 7/25/2017.
 */

open class Animal() : RealmObject() {

    @PrimaryKey var animalID: Long = 0
    var animalName: String? = ""
    var animalAge: Int = 0
    var animalType: String? = ""

    constructor(name: String, age: Int, type: String): this() {
        animalName = name
        animalAge = age
        animalType = type
    }
    override fun toString(): String {
        return "animalID => $animalID animalName => $animalName"
    }
}
