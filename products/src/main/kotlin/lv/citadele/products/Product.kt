package lv.citadele.products

import java.math.BigDecimal

class Product(
        val name: String,
        val price: String
) {
    companion object {
        val STUDENTU = Product(
            name = "Studentu",
            price = "0.49 eur"
        )
        val RIEKSTKODIS = Product(
                name = "Riekstkodis",
                price = "1.50 eur"
        )
        val SPAIDERS = Product(
                name = "Spaiders",
                price = "1.50 eur"
        )
    }
}