package by.ivkos.kotlin.hotelService.web.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/hotel")
open class HotelController {

    @RequestMapping
    @ResponseBody
    open fun allHotels(): String {
        return "allHotels"
    }

    @RequestMapping("/{hotelName}")
    @ResponseBody
    open fun getHotel(@PathVariable hotelName: String): String {
        return hotelName
    }

    @RequestMapping("/{hotelName}/{hotelRoom}")
    @ResponseBody
    open fun getHotelRoom(@PathVariable hotelName: String, @PathVariable hotelRoom: String): String {
        return hotelName + hotelRoom
    }


}