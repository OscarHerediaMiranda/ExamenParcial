package com.example.applistproduct.model

import com.google.gson.annotations.SerializedName

class ProductResponse (
    @SerializedName("type")
    var type: String,

    @SerializedName("products")
    var products: List<Product>
        )