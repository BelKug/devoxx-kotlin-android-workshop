package com.malmstein.samples.beers

open class GetBeersUseCase(private val beersRepository: BeersRepository) {

    suspend operator fun invoke(): List<Beer> = beersRepository.getAll()

}