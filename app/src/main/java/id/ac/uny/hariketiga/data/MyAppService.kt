package id.ac.uny.hariketiga.data


import id.ac.uny.hariketiga.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyAppService {
    @GET("bins/1585qw")
    fun getProducts(): Call<List<Product>>

    companion object Factory{
        fun create(): MyAppService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.myjson.com/")
                    .build()

            return retrofit.create(MyAppService::class.java)
        }
    }
}