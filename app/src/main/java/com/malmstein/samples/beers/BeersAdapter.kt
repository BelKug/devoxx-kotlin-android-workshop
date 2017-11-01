package com.malmstein.samples.beers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class BeersAdapter(var beers: List<String>) : BaseAdapter() {

    override fun getCount() = beers.size

    override fun getItem(i: Int) = beers[i]

    override fun getItemId(i: Int) = i.toLong()

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        val suggestion = getItem(i)
        val rowView = view ?: LayoutInflater.from(viewGroup.context).inflate(R.layout.view_beer_item, viewGroup, false)

        return rowView
    }

    fun updateBeers(newBeers: List<String>) {
        beers = newBeers
        notifyDataSetChanged()
    }

}

