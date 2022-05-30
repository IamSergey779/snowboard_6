package Domain

class Product(val name: String, val price: Int) {
    override fun toString(): String {
        return "$name $price"
    }
}