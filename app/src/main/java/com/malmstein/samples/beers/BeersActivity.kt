package com.malmstein.samples.beers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ListView

class BeersActivity : AppCompatActivity(), ViewCallback {

    val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    val list: ListView by lazy { find<ListView>(R.id.beers_list) }
    val loadingView: View by lazy { find<View>(R.id.beers_loading_view) }

    val adapter: BeersAdapter
    val presenter: BeersPresenter

    init {
        presenter = BeersPresenter(this, GetBeersUseCase(BeersDataRepository))
        adapter = BeersAdapter(
                emptyList(),
                itemClick = { beer -> open(beer) })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beers)

        // Change toolbar title
        toolbar.title = "Beers at Devoxx"
        loadingView.visibility = View.GONE

        list.adapter = adapter

        presenter.showBeers()
    }

    fun open(beer: Beer) {
        toast(beer.name).also { BeerDetailActivity.open(this) }
    }

    override fun render(state: ViewState) {
        when(state){
            is ViewState.Loading -> onLoading()
            is ViewState.Error -> onError(state.exception)
            is BeersViewState.Beers -> onBeers(state.beers)
        }
    }

    private fun onLoading() {
        loadingView.visibility = View.VISIBLE
        list.visibility = View.GONE
    }

    fun onBeers(beers: List<Beer>) {
        loadingView.visibility = View.GONE
        list.visibility = View.VISIBLE
        adapter.updateBeers(beers)
    }

    fun onError(exception: Exception) {
        toast(exception.localizedMessage)
    }

}

