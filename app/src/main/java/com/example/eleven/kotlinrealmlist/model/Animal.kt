package com.example.eleven.kotlinrealmlist.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

/**
 * Created by ELEVEN on 7/25/2017.
 */

open class Animal : RealmObject() {

    @PrimaryKey
    @Required
    var animalID: Int = 0

    var animalName: String? = null
    var animalAge: Int? = null
    var animalType: String? = null
}
