package com.example.eleven.kotlinrealmlist.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ELEVEN on 7/25/2017.
 */

open class Animal(@PrimaryKey var animalID: Long = 0) : RealmObject() {

    var animalName: String? = ""
    var animalAge: Int = 0
    var animalType: String? = ""

    constructor(id: Long, name: String): this(id) {
        animalID = id
        animalName = name
    }
    override fun toString(): String {
        return "animalID => $animalID animalName => $animalName"
    }
}
