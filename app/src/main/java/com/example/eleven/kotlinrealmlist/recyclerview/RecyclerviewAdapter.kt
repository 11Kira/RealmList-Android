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

class RecyclerviewAdapter(data: OrderedRealmCollection<Animal>?, autoUpdate: Boolean) : RealmRecyclerViewAdapter<Animal, RecyclerviewAdapter.ViewHolder>(data, autoUpdate) {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(data?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var itemView: View = LayoutInflater.from(parent?.context).inflate(R.layout.layout_recyclerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemId(index: Int): Long {
        return super.getItemId(index)
    }


    class ViewHolder(itemView : View?): RecyclerView.ViewHolder(itemView) {

        fun bind(animal: Animal?) = with(itemView) {
            txtAnimalID.text = animal?.animalID.toString()
            txtAnimalName.text = animal?.animalName
            txtAnimalAge.text = animal?.animalAge.toString()
            txtAnimalType.text = animal?.animalType
        }
    }
}
