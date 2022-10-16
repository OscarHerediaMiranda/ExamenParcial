package com.example.applistproduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applistproduct.model.Product
import com.example.applistproduct.model.ProductResponse
import com.example.applistproduct.service.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FindProductActivity : AppCompatActivity(), OnItemClickListener {

    override fun OnItemClicked(product: Product) {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_product)
    }

    lateinit var products: List<Product>
    lateinit var productAdapter: ProductAdapter

    override fun onResume() {
        super.onResume()
        loadProduct()

        productAdapter = ProductAdapter(products, this)
        val rvProduct = findViewById<RecyclerView>(R.id.rvProduct)
        rvProduct.adapter = productAdapter
        rvProduct.layoutManager = LinearLayoutManager(this)
    }

    fun loadProduct(){

        //1. crear la instancia del retrofit
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/food/products/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //2. inyectar el servicio creado a la instancia retrofit
        var productService: ProductService
        productService = retrofit.create(ProductService::class.java)

        //3. llamar a la funcion getJoke() (aqui se arma el request)
        var request = productService.getProduct("json")

        //4. se va a acceder a la respuesta del api (se recibe el response)
        request.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if(response.isSuccessful){
                    Log.e("RESPONSE","${response.body()}")
                    products = response.body()!!.products;
                    //txtJoke.text = response.body()!!.joke;
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e("RESPONSE","HUBO UN ERROR")
            }
        })
    }
}