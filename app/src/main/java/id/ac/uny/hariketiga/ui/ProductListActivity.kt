package id.ac.uny.hariketiga.ui

import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.solver.GoalRow
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import id.ac.uny.hariketiga.R
import id.ac.uny.hariketiga.data.repository.ProductRepositoryImpl
import id.ac.uny.hariketiga.model.Product
import id.ac.uny.hariketiga.ui.adapter.ProductItem
import id.ac.uny.hariketiga.ui.adapter.ProductListener
import kotlinx.android.synthetic.main.activity_product_list.*
import org.jetbrains.anko.toast

class ProductListActivity : AppCompatActivity(), ProductListView, ProductListener {
    lateinit var presenter: ProductListPresenter
    val productAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val productRepo = ProductRepositoryImpl()

        //set recycleview
        rvProductList.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@ProductListActivity)
        }
        presenter = ProductListPresenter(this, productRepo)
        presenter.ambilProducts()

    }

    override fun showLoading() {
       loading.visibility = VISIBLE
        rvProductList.visibility = GONE
    }

    override fun hideLoading() {
        loading.visibility = GONE
        rvProductList.visibility = VISIBLE
    }

    override fun showData(listProdut: List<Product>) {
        //show data ke recycleview
        Log.d("show", "datanya ${listProdut.size}")

        listProdut.map {
            Log.d("show", "datanya ${it.nama}")
            productAdapter.add(ProductItem(it, this))
        }
    }

    override fun showError(errorMessage: String) {
        loading.visibility = GONE
        rvProductList.visibility = GONE
        tvError.visibility = VISIBLE
    }

    override fun onProductCLick(product: Product) {
        toast("show ${product.nama + product.harga}")
    }

}
