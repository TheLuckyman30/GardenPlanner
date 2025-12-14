package com.example.gardenplanner.utils.classes

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("plants/varieties/name")
    suspend fun getPlantInfo(
        @Query("q") q: String,
        @Query("page") page: Int,
        @Header("x-rapidapi-key") apiKey: String,
        @Header("x-rapidapi-host") host: String
    ): PlantApiResponse
}