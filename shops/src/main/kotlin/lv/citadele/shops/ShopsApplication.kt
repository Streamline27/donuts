package lv.citadele.shops

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShopsApplication

fun main(args: Array<String>) {
    runApplication<ShopsApplication>(*args)
}