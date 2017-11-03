package com.malmstein.samples.beers

data class Beer(val name: String, val trappist: Boolean)
infix fun Beer.isTheSameAs(value: Beer) = this == value

interface BeersRepository {
    fun getAll(): List<Beer>;
    fun getTrappist(): List<Beer>;
}

object BeersDataRepository : BeersRepository {

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