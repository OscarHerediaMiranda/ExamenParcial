package com.example.applistproduct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btFindProduct = findViewById<Button>(R.id.btFindProduct)
        btFindProduct.setOnClickListener {
            var intent = Intent(this,FindProductActivity::class.java);
            startActivity(intent);
        }

        var btFavouriteProduct = findViewById<Button>(R.id.btFavouriteProduct)
        btFavouriteProduct.setOnClickListener {
            var intent = Intent(this,FavouriteProductActivity::class.java);
            startActivity(intent);
        }
    }


}