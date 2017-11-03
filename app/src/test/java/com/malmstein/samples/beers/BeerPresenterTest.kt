package com.malmstein.samples.beers

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class BeerPresenterTest {

    var viewCallback : ViewCallback = mock<ViewCallback>()
    var repository : BeersRepository = mock<BeersRepository>()

    lateinit var presenter: BeersPresenter

    @Before fun setup(){
        presenter = BeersPresenter(viewCallback, repository);
    }

    @Test fun `renders beers in view`() {

        val beers = listOf<Beer>(
                Beer("Jupiler", false),
                Beer("Westmalle", true),
                Beer("Rochefort 8", true))

        whenever(repository.getAll()).thenReturn(beers)

        presenter.showBeers()

        verify(viewCallback).render(ViewState.Loading)
        verify(viewCallback).render(BeersViewState.Beers(beers))

        assertTrue(beers[0] isTheSameAs (beers[1]))
    }
}