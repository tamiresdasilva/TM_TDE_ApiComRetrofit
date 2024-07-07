package com.example.apicomretrofit.data.datasources

import com.example.apicomretrofit.data.network.CharactersApi
import com.example.apicomretrofit.data.network.responses.ResultsResponse
import javax.inject.Inject

class CharactersDataSource @Inject constructor(private val api: CharactersApi) {
    suspend fun fetchCharacters(): ResultsResponse {
        return api.fetchCharacters()
    }
}