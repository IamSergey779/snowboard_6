import Data.RepositoryImpl
import Domain.AddUseCase
import Domain.ListUseCase
import Domain.SellUseCase
import Domain.SortedUseCase
import Presenter.Presenter
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val listProduct = RepositoryImpl()
    val listReturn = ListUseCase(listProduct)
    val sortedList = SortedUseCase(listProduct)
    val addProduct = AddUseCase(listProduct)
    val sellProduct = SellUseCase(listProduct)
    val present = Presenter(listReturn, sortedList, addProduct, sellProduct)

    val serverSocket = ServerSocket(4545)
    while (true) {
        val sock = serverSocket.accept()
        val input = InputStreamReader(sock.getInputStream())
        val userCommand = BufferedReader(input).readLine().lowercase()
        val writer = PrintWriter(sock.getOutputStream())
        val result = present.userInputProcessing(userCommand)
        if (result.isEmpty()) {
            println("Exit program!")
            exitProcess(1)
        } else {
            writer.println(result)
            writer.flush()
        }
    }
}