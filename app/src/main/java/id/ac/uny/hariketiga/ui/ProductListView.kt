package id.ac.uny.hariketiga.ui

import id.ac.uny.hariketiga.model.Product

interface ProductListView {
    fun showLoading()
    fun hideLoading()
    fun showData(listProdut: List<Product>)
    fun showError(errorMessage: String)
}