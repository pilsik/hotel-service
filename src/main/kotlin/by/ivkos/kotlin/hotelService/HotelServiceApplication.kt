package by.ivkos.kotlin.hotelService

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class HotelServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(HotelServiceApplication::class.java, *args)
}


