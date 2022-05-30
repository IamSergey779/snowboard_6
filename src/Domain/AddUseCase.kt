package Domain

import Data.RepositoryImpl

class AddUseCase(val product: RepositoryImpl) {
    fun addUseCase(newProduct: Product): List<Product> {
        return product.add(newProduct)
    }
}