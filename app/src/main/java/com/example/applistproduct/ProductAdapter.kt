package com.example.applistproduct

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.applistproduct.model.Product

class ProductAdapter(val products: List<Product>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<ProductPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototipe_product, parent,false)

        return ProductPrototype(view)
    }

    override fun onBindViewHolder(holder: ProductPrototype, position: Int) {
        holder.bind(products.get(position), itemClickListener)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}

class ProductPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvId = itemView.findViewById<TextView>(R.id.tvId)
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    val tvImage = itemView.findViewById<TextView>(R.id.tvImage)
    val cvProduct = itemView.findViewById<CardView>(R.id.cvProduct)

    fun bind(product: Product, itemClikListener: OnItemClickListener){
        tvId.text = product.id
        tvTitle.text = product.name
        tvImage.text = product.photoProduct

        cvProduct.setOnClickListener {
            itemClikListener.OnItemClicked(product)
        }
    }
}

interface OnItemClickListener{
    fun OnItemClicked(product: Product)
}