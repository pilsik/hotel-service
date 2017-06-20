package by.ivkos.kotlin.pin_service.service

import by.ivkos.kotlin.pin_service.domain.Pin

interface PinService {

    fun addPin(pin: Pin): Pin
    fun getPinById(id: Long): Pin
    fun removePinById(id: Long): Pin
    fun getPinByApiToken(api_token: String): Pin

}