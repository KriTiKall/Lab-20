package logic.factories

import logic.entities.Contract
import logic.entities.Product
import logic.entities.Shipment
import java.util.*

class BakeryPlant : Factory {

    companion object {
        private var number: Long = 0
    }

    private val listOfProduct: List<Product> = listOf(
            Product("Белый хлеб", 25.0, "Очень вкусный хлеб", "132144", 5),
            Product("Батон", 26.0, "Очень вкусный батон к чаю", "132145", 5),
            Product("Булка с сахаром", 27.0, "Сладкая булочка", "132146", 4),
            Product("Чёрный хлеб", 23.0, "Хлеб для диет", "132147", 6)
    )

    private fun makeList(code: String, count: Int): List<Product> {
        val index = listOfProduct.indexOf(listOfProduct.find { code.equals(it.code) })
        val list: MutableList<Product> = mutableListOf()

        for (x in 1..count)
            list.add(listOfProduct[index])

        return list
    }

    private fun contractToMap(contract: Contract): Map<String, List<Product>> { // mam<code, list>
        val productMap: MutableMap<String, List<Product>> = mutableMapOf() // map<name, list>
        var list: List<Product>

        for (x in contract.codeAndCount.keys) {
            list = contract.get(x)?.let {
                makeList(x, it)
            } ?: listOf()
            productMap.put(list.get(0).name, list)
        }
        return productMap
    }

    override fun getCodes(): List<String> =
            listOfProduct.map { it.code }

    override fun getNames(): List<String> =
            listOfProduct.map { it.name }

    override fun getListOfProduct(): List<Product> =
            listOfProduct

    override fun fabricate(contract: Contract): Shipment =
            Shipment(number++, Date(), contractToMap(contract))
}