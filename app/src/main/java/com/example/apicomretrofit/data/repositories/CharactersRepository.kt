package com.example.apicomretrofit.data.repositories

import com.example.apicomretrofit.data.Character
import com.example.apicomretrofit.data.datasources.CharactersDataSource
import com.example.apicomretrofit.data.network.responses.toModel
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val charactersDataSource: CharactersDataSource) {
    suspend fun fetchCharacters(): List<Character> {
        return charactersDataSource
            .fetchCharacters()
            .charactersResult.map { item -> item.toModel() }
    }
}