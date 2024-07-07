package com.example.apicomretrofit.data.network

import com.example.apicomretrofit.data.network.responses.ResultsResponse
import retrofit2.http.GET

interface CharactersApi {
    @GET("character")
    suspend fun fetchCharacters(): ResultsResponse
}