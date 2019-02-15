package id.ac.uny.hariketiga.ui.adapter

import id.ac.uny.hariketiga.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import id.ac.uny.hariketiga.model.Product
import kotlinx.android.synthetic.main.item_product_list.view.*

interface ProductListener{
    fun onProductCLick(product: Product)
}
class ProductItem(val product: Product,
                  val listener: ProductListener) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val tvProductName = viewHolder.itemView.tvProductName
        val tvProductPrice = viewHolder.itemView.tvProcustPrice

        tvProductName.text = product.nama
        tvProductPrice.text = "${product.harga}"

        viewHolder.itemView.setOnClickListener {
            listener.onProductCLick(product)
        }
    }

    override fun getLayout(): Int {
       return R.layout.item_product_list
    }

}