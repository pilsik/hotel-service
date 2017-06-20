package by.ivkos.kotlin.hotelService.dao.pin

import by.ivkos.kotlin.hotelService.dao.GenericDaoImpl
import by.ivkos.kotlin.hotelService.domain.Pin
import org.springframework.stereotype.Repository
import javax.websocket.Session


@Repository
open class PinDaoImpl : GenericDaoImpl<Pin, Long>(), PinDao {

    override fun getPinByApiToken(api_token: String): Pin {
        return em.createQuery("SELECT p FROM Pin p WHERE p.api_token=:api_token_value", Pin::class.java)
                .setParameter("api_token_value", api_token)
                .singleResult
    }

}