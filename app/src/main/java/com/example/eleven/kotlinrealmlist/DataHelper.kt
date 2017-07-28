package com.example.eleven.kotlinrealmlist

import android.util.Log
import com.example.eleven.kotlinrealmlist.model.Animal
import io.realm.Realm
import io.realm.RealmResults
import java.util.concurrent.atomic.AtomicInteger


/**
 * Created by ELEVEN on 7/25/2017.
 */
open class DataHelper {

    val TAG: String = DataHelper::class.java.simpleName

    companion object {
        var INTEGER_COUNTER: AtomicInteger = AtomicInteger(0)
        fun increment(): Int{
            return INTEGER_COUNTER.getAndIncrement()
        }
    }

    fun addItemAsync(realm: Realm?, animal: Animal){
        var lastAnimalID: Long? = 0
        try {
            lastAnimalID = realm?.where(Animal::class.java)?.findAllSorted("animalID")?.last()?.animalID
            Log.d(TAG, "apply")
        } catch(e: Exception) {
            e.printStackTrace()
        }
        Log.d(TAG, "lastAnimalID: " + lastAnimalID)
        animal.animalID = lastAnimalID?.inc() as Long
        Log.d(TAG, "animal: " + animal.toString())

        realm?.executeTransaction {
            var animals: Animal = realm?.createObject(Animal::class.java, animal.animalID)
            animals.animalName = animal.animalName
            animals.animalAge = animal.animalAge
            animals.animalType = animal.animalType
            realm.copyToRealm(animals)
        }
    }

    fun deleteItemAsync(realm: Realm?){
        var results: RealmResults<Animal>? = realm?.where(Animal::class.java)?.findAll()

        realm?.executeTransaction {
            results?.deleteAllFromRealm()
        }
    }

    @Synchronized fun getNextKey(realm: Realm): Long {
        try {
            return realm.where(Animal::class.java).max("item_id").toLong() + 1
        } catch (e: Exception) {
            return 0
        }

    }


}