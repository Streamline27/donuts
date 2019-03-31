package lv.citadele.shops

import lv.citadele.shops.model.Shop
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ShopsController {
    @GetMapping("/shops")
    fun shops() = listOf(
            Shop.ATVERTS,
            Shop.STREETBURGER
    )
}