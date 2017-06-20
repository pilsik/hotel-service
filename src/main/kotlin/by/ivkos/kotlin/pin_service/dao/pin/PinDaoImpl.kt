package by.ivkos.kotlin.pin_service.dao.pin

import by.ivkos.kotlin.pin_service.dao.GenericDaoImpl
import by.ivkos.kotlin.pin_service.domain.Pin
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Repository
import javax.transaction.Transactional


@Repository
open class PinDaoImpl : GenericDaoImpl<Pin, Long>(), PinDao {

    override fun getPinByApiToken(api_token: String): Pin {
        return em.createQuery("SELECT p FROM Pin p WHERE p.api_token=:api_token_value", Pin::class.java)
                .setParameter("api_token_value", api_token)
                .singleResult
    }


    @Scheduled(cron = "2 * * * * ?")
    @Transactional
    override fun removeExpiredPins() {
        val currentTime = System.currentTimeMillis()
        val expiredTime = currentTime - 2 * 60 * 1000
        em.createQuery("SELECT p FROM Pin p WHERE p.timestamp < :expiredTime", Pin::class.java)
                .setParameter("expiredTime", expiredTime)
                .resultList.forEach {
            println("$expiredTime > ${it.timestamp}")
            println("delete pin: $it")
            super.em.remove(it as Pin)
        }
    }
}