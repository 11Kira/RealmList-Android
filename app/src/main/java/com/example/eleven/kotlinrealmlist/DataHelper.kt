package com.example.eleven.kotlinrealmlist

import io.realm.Realm

/**
 * Created by ELEVEN on 7/25/2017.
 */
class DataHelper {

    fun addItemAsync(realm: Realm){
        realm.executeTransaction {  }
    }

    fun deleteItemAsync(realm: Realm){
        realm.executeTransaction {  }
    }

}