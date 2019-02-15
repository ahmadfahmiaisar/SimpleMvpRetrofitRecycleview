package id.ac.uny.hariketiga.data.repository

import id.ac.uny.hariketiga.model.Product
import retrofit2.Call

interface ProductRepository {
    fun getProducts(): Call<List<Product>>
    fun saveProduct(): Boolean
    fun deleteProduct(id: Int):Boolean
}