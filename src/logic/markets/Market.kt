package logic.markets

import logic.entities.Shipment

interface Market {

    fun orderedProducts(nameAndCount: Map<String, Int>)
    fun printProducts()
    fun showProviderProducts() : List<String>
}