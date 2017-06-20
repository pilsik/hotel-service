package by.ivkos.kotlin.hotelService.service

import by.ivkos.kotlin.hotelService.domain.Pin

interface PinService {

    fun addPin(pin: Pin): Pin
    fun getPinById(id: Long): Pin
    fun removePinById(id: Long): Pin
    fun getPinByApiToken(api_token: String): Pin

}