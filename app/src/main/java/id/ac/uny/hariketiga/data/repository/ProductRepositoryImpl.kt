package id.ac.uny.hariketiga.data.repository

import id.ac.uny.hariketiga.data.MyAppService
import id.ac.uny.hariketiga.model.Product
import retrofit2.Call

class ProductRepositoryImpl : ProductRepository{
    override fun getProducts(): Call<List<Product>> {
        return MyAppService.create().getProducts()
    }

    override fun saveProduct(): Boolean {
        return false
    }

    override fun deleteProduct(id: Int): Boolean {
        return false
    }

}