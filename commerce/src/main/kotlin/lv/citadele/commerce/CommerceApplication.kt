package lv.citadele.commerce

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
@SpringBootApplication
class CommerceApplication {
   @Bean
   fun restTemplate() = RestTemplate()
}

fun main(args: Array<String>) {
    runApplication<CommerceApplication>(*args)
}