package com.example.applistproduct.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity()
class Product (
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    var id: String,

    @SerializedName("title")
    @ColumnInfo
    var name: String,

    @SerializedName("image")
    @ColumnInfo
    var photoProduct: String
        )