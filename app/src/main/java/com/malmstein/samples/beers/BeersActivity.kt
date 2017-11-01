package com.malmstein.samples.beers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ListView

class BeersActivity : AppCompatActivity() {

    val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    val list: ListView by lazy { findViewById<ListView>(R.id.beers_list) }
    val loadingView: View by lazy { findViewById<View>(R.id.beers_loading_view) }

    val adapter: BeersAdapter

    init {
        val beers = listOf<String>("Duvel", "Westmalle", "Rochefort")
        adapter = BeersAdapter(beers)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beers)

        // Change toolbar title
        toolbar.title = "Beers at Devoxx"
        loadingView.visibility = View.GONE

        // Add list adapter
        list.apply {
            val beers = listOf<String>("Duvel", "Westmalle", "Rochefort")
            adapter = BeersAdapter(beers, BeersAdapter.Listener() )
        }

    }
}

