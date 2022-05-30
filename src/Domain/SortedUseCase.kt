package Domain

import Data.RepositoryImpl

class SortedUseCase(val product: RepositoryImpl) {
    fun sortedUseCase(): List<Product> {
        return product.listAndSort().sortedBy { it.name }
    }
}