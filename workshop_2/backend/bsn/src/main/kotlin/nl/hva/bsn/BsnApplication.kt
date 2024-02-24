package nl.hva.bsn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BsnApplication

fun main(args: Array<String>) {
    runApplication<BsnApplication>(*args)
}
