package com.example.eleven.kotlinrealmlist.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eleven.kotlinrealmlist.R

import com.example.eleven.kotlinrealmlist.model.Animal
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter

class RecyclerviewAdapter(animal: OrderedRealmCollection<Animal>?, autoUpdate: Boolean) : RealmRecyclerViewAdapter<Animal, RecyclerviewAdapter.ViewHolder>(animal, autoUpdate) {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var itemView: View = LayoutInflater.from(parent?.context).inflate(R.layout.layout_recyclerview_item, parent, false)
        return ViewHolder(itemView)
    }


    class ViewHolder(view : View?): RecyclerView.ViewHolder(view) {

    }
}
