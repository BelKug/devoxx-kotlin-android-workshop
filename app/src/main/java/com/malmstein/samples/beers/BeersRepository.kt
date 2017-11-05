package com.malmstein.samples.beers

import ru.gildor.coroutines.retrofit.awaitResult
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

data class Brewery(val id: Long, val breweryName: String)
data class BeerType(val id: Long, val beerType: String, val beerJudgeCertification: String)
data class Beer(val id: Long, val beerName: String,
                val alcoholPercentage: Double, val beerColour: String,
                val beerType: BeerType, val brewery: Brewery)

infix fun Beer.isTheSameAs(value: Beer) = this == value

interface BeersRepository {
    suspend fun getAll(): List<Beer>;
}

object BeersDataRepository : BeersRepository {

    var isOnline: Boolean by NetworkDelegate()
    val api: BeersApiService by lazy {
        BeersApiService.create()
    }

    suspend override fun getAll(): List<Beer> {
        api
                .beers()
                .awaitResult()
                .ifSucceeded { value -> return value }
                .ifFailed { return@ifFailed }
                .ifError fail@ { error -> return@fail }

        return emptyList()
    }

}

class NetworkDelegate : ReadWriteProperty<Any?, Boolean> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): Boolean {
        return true
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
    }
}
