package by.ivkos.kotlin.hotelService.dao.hotel

import by.ivkos.kotlin.hotelService.dao.GenericDaoImpl
import by.ivkos.kotlin.hotelService.domain.Hotel
import org.springframework.stereotype.Repository

@Repository
open class HotelDaoImpl : GenericDaoImpl<Hotel, Long>(), HotelDao