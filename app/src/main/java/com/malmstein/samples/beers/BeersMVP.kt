package com.malmstein.samples.beers

import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

sealed class ViewState {
    object Loading : ViewState()
    data class Error(val exception: Exception) : ViewState()
}

sealed class BeersViewState : ViewState() {
    data class Beers(val beers: List<Beer>) : BeersViewState()
}

interface ViewCallback {
    fun render(state: ViewState)
}

class BeersPresenter(val view: ViewCallback, val getBeersUseCase: GetBeersUseCase) {

    fun showBeers() = launch(UI) {
        view.render(ViewState.Loading)
        val beers = async { getBeersUseCase() }.await()
        view.render(BeersViewState.Beers(beers))
    }

}