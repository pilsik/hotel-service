package by.ivkos.kotlin.pin_service.dao.pin

import by.ivkos.kotlin.pin_service.dao.GenericDao
import by.ivkos.kotlin.pin_service.domain.Pin

interface PinDao : GenericDao<Pin, Long> {
    fun getPinByApiToken(api_token: String): Pin
    fun removeExpiredPins()
}