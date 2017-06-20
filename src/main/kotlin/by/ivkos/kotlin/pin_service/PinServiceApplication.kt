package by.ivkos.kotlin.pin_service

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
open class HotelServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(HotelServiceApplication::class.java, *args)
}


