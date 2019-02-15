package id.ac.uny.hariketiga.ui

import android.util.Log
import id.ac.uny.hariketiga.data.repository.ProductRepository
import id.ac.uny.hariketiga.model.Product
import retrofit2.Call
import retrofit2.Response

class ProductListPresenter (val view: ProductListView,
                            val productRepository: ProductRepository) {

    fun ambilProducts() {
        view.showLoading()

        productRepository.getProducts().enqueue(object : retrofit2.Callback<List<Product>> {

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                view.hideLoading()
                if (response.isSuccessful){
                    val result = response.body()
                    if (result.isNullOrEmpty()){
                        view.showError("Product is empty")
                    }else{
                        view.showData(result)
                    }
                } else
                    Log.e("error", "gak sukses responya ${response.message()}")
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                view.hideLoading()
                Log.e("error", "failed ${t.message}")
            }

        })
    }
}