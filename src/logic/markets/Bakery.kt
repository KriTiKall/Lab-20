package logic.markets

import logic.entities.Product
import logic.entities.Shipment
import logic.providers.Provider
import java.lang.StringBuilder

class Bakery(provider: Provider) : Market {

    private val provider = provider
    val mapOfProducts: Map<String, MutableList<Product>> = provider
            .showProducts()
            .map { it to mutableListOf<Product>() }
            .toMap()

    override fun orderedProducts(nameAndCount: Map<String, Int>) {
        val mapFromProvider = provider.provide(nameAndCount).nameAndProduct
        for(key in mapFromProvider.keys)
            mapOfProducts[key]?.addAll(mapFromProvider[key]!!)
    }

    override fun printProducts() {
        println("Products of bakery:")
        mapOfProducts.keys.forEach{
            println("  $it (count: ${mapOfProducts[it]})")
            mapOfProducts[it]?.forEach { println("    ${it.toStringForPrint()}") }
        }
    }

    override fun showProviderProducts(): List<String> =
            provider.showProducts()

    override fun toString(): String {
        val string = StringBuilder("Products of bakery:\n")
        mapOfProducts.keys.forEach{
            if (mapOfProducts[it].let{it != null && it.isEmpty() == false}){
                string.append("   $it (count: ${mapOfProducts[it]?.size})\n")
                mapOfProducts[it]?.forEach { string.append("      ${it.toStringForPrint()}\n") }
            }
        }
        return string.toString()
    }
}