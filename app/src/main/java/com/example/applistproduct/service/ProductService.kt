package com.example.applistproduct.service

import com.example.applistproduct.model.Product
import com.example.applistproduct.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("search?query=arroz&number=50&apiKey=c7008af69b794968886eefd3607e24af")
    fun getProduct(@Query("format")format:String): Call<ProductResponse>
}