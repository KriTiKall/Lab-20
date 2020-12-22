package logic.providers

import logic.entities.Contract
import logic.entities.Product
import logic.entities.Shipment
import logic.factories.Factory

/*
 * Later this class will store and sort products using the warehouse class
 */
class BakeryProvider(factory: Factory) : Provider {

    private val factory = factory;

    private fun nameToCode(nameAndCount: Map<String, Int>) : Map<String, Int>{
        val codeAndCount: MutableMap<String, Int> = mutableMapOf()
        val products : List<Product?> = nameAndCount.keys.map{ iit -> factory.getListOfProduct().find { it -> iit.equals(it.name) }}
        for (product in products)
            product?.let { codeAndCount.put(it.code, nameAndCount.get(it.name)!!) }
        return codeAndCount
    }

    override fun provide(nameAndCount: Map<String, Int>): Shipment =
            factory.fabricate(Contract(13, nameToCode(nameAndCount)))

    override fun showProducts(): List<String> =
            factory.getNames()
}