package by.ivkos.kotlin.hotelService.dao.pin

import by.ivkos.kotlin.hotelService.dao.GenericDao
import by.ivkos.kotlin.hotelService.domain.Pin

interface PinDao : GenericDao<Pin, Long> {
    fun  getPinByApiToken(api_token: String): Pin
}