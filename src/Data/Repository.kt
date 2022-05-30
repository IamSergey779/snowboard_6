package Data

import Domain.Product

interface Repository {
    fun listAndSort(): List<Product>
    fun add(product: Product): List<Product>
    fun sell(name: String): List<Product>
}

class RepositoryImpl : Repository {
    val snowboard_1 = Product("Joint", 40)
    val snowboard_2 = Product("Solomon", 45)
    val snowboard_3 = Product("Burton", 50)
    val snowboard_4 = Product("Atom", 35)
    val listOfProduct = mutableListOf<Product>(snowboard_1, snowboard_2, snowboard_3, snowboard_4)


    override fun listAndSort(): List<Product> {
        return listOfProduct
    }

    override fun add(product: Product): List<Product> {
        listOfProduct.add(product)
        return listOfProduct
    }

    override fun sell(name: String): List<Product> {
        val deletProduct = listOfProduct.find { it.name.lowercase() == name.lowercase() }
        listOfProduct.remove(deletProduct)
        return listOfProduct
    }

}