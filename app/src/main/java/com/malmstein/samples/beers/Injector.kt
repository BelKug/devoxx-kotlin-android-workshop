package com.malmstein.samples.beers

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

object Injector {

    fun getBeersPresenter(view: ViewCallback): ReadOnlyProperty<Any?, BeersPresenter> = object : ReadOnlyProperty<Any?, BeersPresenter> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): BeersPresenter {
            return BeersPresenter(view, getBeers)
        }
    }

    private val getBeers: GetBeersUseCase
        get() {
            return GetBeersUseCase(repository)
        }

    private val repository: BeersRepository
        get () {
            return BeersDataRepository
        }
}