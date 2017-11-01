package com.malmstein.samples.beers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BeersAdapter(var beers: List<String>, var listener: Listener) : BaseAdapter() {

    init {
        notifyDataSetChanged()
    }

    override fun getCount() = beers.size

    override fun getItem(i: Int) = beers[i]

    override fun getItemId(i: Int) = i.toLong()

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        val beer = getItem(i)
        val rowView = view ?: LayoutInflater.from(viewGroup.context).inflate(R.layout.view_beer_item, viewGroup, false)
            rowView.findViewById<TextView>(R.id.beer_item_label).apply {
                text = beer
            }

        rowView.setOnClickListener { listener.onBeerClicked(beer) }

        return rowView
    }

    fun updateBeers(newBeers: List<String>) {
        beers = newBeers
        notifyDataSetChanged()
    }

    interface Listener {
        fun onBeerClicked(beer: String)
    }

}

