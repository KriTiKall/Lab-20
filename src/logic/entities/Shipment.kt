package logic.entities

import java.util.*

data class Shipment(
        var number: Long,
        val date: Date,
        val nameAndProduct: Map<String,List<Product>>
)
