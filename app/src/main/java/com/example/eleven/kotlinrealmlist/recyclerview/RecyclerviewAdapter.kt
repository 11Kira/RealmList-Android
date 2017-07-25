package com.example.eleven.kotlinrealmlist.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eleven.kotlinrealmlist.R

import com.example.eleven.kotlinrealmlist.model.Animal
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.layout_recyclerview_item.view.*

class RecyclerviewAdapter(animals: OrderedRealmCollection<Animal>?, autoUpdate: Boolean) : RealmRecyclerViewAdapter<Animal, RecyclerviewAdapter.ViewHolder>(animals, autoUpdate) {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var animals: Animal? = getItem(position)
        holder?.name?.text = animals?.animalName
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var itemView: View = LayoutInflater.from(parent?.context).inflate(R.layout.layout_recyclerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemId(index: Int): Long {
        return super.getItemId(index)
    }


    class ViewHolder(itemView : View?): RecyclerView.ViewHolder(itemView) {
        var name = itemView?.txtAnimalName
        var type = itemView?.txtAnimalType
        var age = itemView?.txtAnimalAge
    }
}
