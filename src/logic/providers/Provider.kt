package logic.providers

import logic.entities.Shipment

interface Provider {
    fun provide(nameAndCount: Map<String, Int>) : Shipment
    fun showProducts() : List<String>
}