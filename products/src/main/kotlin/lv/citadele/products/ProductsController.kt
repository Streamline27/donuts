package lv.citadele.products

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductsController {
    @GetMapping("/products")
    fun products() = listOf(
            Product.RIEKSTKODIS,
            Product.SPAIDERS,
            Product.STUDENTU
    )
}