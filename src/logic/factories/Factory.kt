package logic.factories

import logic.entities.Contract
import logic.entities.Product
import logic.entities.Shipment

interface Factory {

    fun getCodes() : List<String>
    fun getNames() : List<String>
    fun getListOfProduct() : List<Product>
    fun fabricate(contract: Contract) : Shipment
}