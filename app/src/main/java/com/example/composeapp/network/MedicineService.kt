package com.example.composeapp.network

import com.example.composeapp.domain.model.Response
import retrofit2.http.GET

interface MedicineService {
    @GET("v3/2badb71b-d274-468e-a138-9303437fb394")
    suspend fun getMedicine(): Response
}