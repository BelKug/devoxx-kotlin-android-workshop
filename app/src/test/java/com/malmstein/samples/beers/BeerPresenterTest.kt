package com.malmstein.samples.beers

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.async
import org.junit.Before
import org.junit.Test

class BeerPresenterTest {

    var viewCallback : ViewCallback = mock<ViewCallback>()
    var repository : BeersRepository = mock<BeersRepository>()

    lateinit var presenter: BeersPresenter

    @Before fun setup(){
        var useCase = GetBeersUseCase(repository)
        presenter = BeersPresenter(viewCallback, useCase);
    }

    @Test fun `renders beers in view`() {

        async(Unconfined) {
            whenever(repository.getAll()).thenReturn(emptyList())
            presenter.showBeers()

            verify(viewCallback).render(ViewState.Loading)
            verify(viewCallback).render(BeersViewState.Beers(emptyList()))

        }


    }
}