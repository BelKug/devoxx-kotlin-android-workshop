package com.malmstein.samples.beers

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

data class Beer(val name: String, var trappist: Boolean )
infix fun Beer.isTheSameAs(value: Beer) = this == value

interface BeersRepository {
    fun getAll(): List<Beer>;
    fun getTrappist(): List<Beer>;
}

object BeersDataRepository : BeersRepository {

    var isOnline: Boolean by NetworkDelegate()

    val beers = listOf<Beer>(
            Beer("Jupiler", false),
            Beer("Westmalle", true),
            Beer("Rochefort 8", true))

    override fun getAll(): List<Beer> {
        return beers
    }

    override fun getTrappist(): List<Beer> {
        return beers.filter { it.trappist == true }
    }

}

class NetworkDelegate : ReadWriteProperty<Any?, Boolean> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): Boolean {
        return true
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
    }
}
