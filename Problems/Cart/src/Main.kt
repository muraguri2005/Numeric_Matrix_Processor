fun main() {
    val productType = readLine()!!
    val price = readLine()!!
    val product = Product(price.toInt(), productType)
    println(totalPrice(product))
}

fun totalPrice(product: Product): Int {

    val tax: Int = when (product.productType) {
        "headphones" -> {
            (product.price * 11) / 100
        }
        "smartphone" -> {
            (product.price * 15) / 100
        }
        "tv" -> {
            (product.price * 17) / 100
        }
        "laptop" -> {
            (product.price * 19) / 100
        }
        else -> {
            0
        }
    }
    return product.price + tax
}

class Product(val price: Int, val productType: String)
