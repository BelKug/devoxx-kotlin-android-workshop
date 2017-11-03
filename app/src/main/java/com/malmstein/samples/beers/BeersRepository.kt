package com.malmstein.samples.beers

data class Beer(val name: String)

interface BeersRepository {
    fun getAll(): List<Beer>;
}

class BeersDataRepository: BeersRepository {

    override fun getAll(): List<Beer> {
        val beers = listOf<Beer>(Beer("Duvel"), Beer("Westmalle"), Beer("Rochefort"))
        return beers
    }

}