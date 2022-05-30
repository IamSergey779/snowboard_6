package Domain

import Data.RepositoryImpl

class SellUseCase(val product: RepositoryImpl) {
    fun sellUseCase(name: String): List<Product> {
        return product.sell(name)
    }
}

//println("Please entered the name of the snowboard to sell:")
//val userSellNameProduct = readln()
//println("Please entered the price of the snowboard to add:")
//val userSellPriceProduct = readln().toInt()
//val userSellProduct = Product(userSellNameProduct, userSellPriceProduct)
//val deletProduct = if (listOfProduct.contains(userSellProduct)){
//
//}
//else
//return product.sell(userSellProduct)