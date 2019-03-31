package lv.citadele.commerce

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class CommerceController(
        val restTemplate: RestTemplate
) {
    @GetMapping("/commerce")
    fun commerce() = runBlocking {
        val shops = async { getShops() }
        val products = getProducts()
        mapOf("products" to products, "shops" to shops.await())
    }

    fun getShops() =
        restTemplate.getForObject("http://localhost:9780/shops", Any::class.java) ?: Object()

    fun getProducts() =
        restTemplate.getForObject("http://localhost:9785/products", Any::class.java) ?: Object()
}