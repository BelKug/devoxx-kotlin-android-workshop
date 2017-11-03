package com.malmstein.samples.beers

interface BeersView {
    fun onBeers(beers: List<Beer>)
    fun onError(exception: Exception)
}

class BeersPresenter (val view: BeersView, val repository: BeersRepository){

    fun showBeers(){
        val beers = repository.getAll()
        view.onBeers(beers)
    }

}