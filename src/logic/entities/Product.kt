package logic.entities

import java.text.SimpleDateFormat
import java.util.*

data class Product(
        val name: String,
        val price: Double,
        val description: String,
        val code: String,
        val shelfLife: Int,
        val dateOfManufacture: Date = Date()
) {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd")

    fun toStringForPrint(): String {
        return "(p=$price, d='$description', c='$code', shelfLife=$shelfLife, date=${dateFormat.format(dateOfManufacture)})"
    }
}