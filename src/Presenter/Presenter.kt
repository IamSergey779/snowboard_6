package Presenter

import Domain.*
import kotlin.system.exitProcess

class Presenter(
    val listReturn: ListUseCase,
    val sortedList: SortedUseCase,
    val addProduct: AddUseCase,
    val sellProduct: SellUseCase
) {
    fun userInputProcessing(userInput: String): List<Product> {
        return if (userInput == "list") {
            listReturn.listUseCase()
        } else if (userInput == "sort") {
            sortedList.sortedUseCase()
        } else if (userInput.startsWith("add")) {
            val userArray = userInput.split(' ')
            val name = userArray[1]
            val price = userArray[2].toInt()
            val newProduct = Product(name, price)
            addProduct.addUseCase(newProduct)
        } else if (userInput.startsWith("sell")) {
            val userArray = userInput.split(' ')
            val nameProduct = userArray[1]
            sellProduct.sellUseCase(nameProduct)
        } else {
            exitProcess(1)
        }
    }
}