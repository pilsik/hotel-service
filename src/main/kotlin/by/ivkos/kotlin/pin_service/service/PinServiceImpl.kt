package by.ivkos.kotlin.pin_service.service

import by.ivkos.kotlin.pin_service.dao.pin.PinDao
import by.ivkos.kotlin.pin_service.domain.Pin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class PinServiceImpl : PinService {

    @Autowired
    lateinit var pinDao: PinDao

    override fun addPin(pin: Pin): Pin {
        return pinDao.add(pin)
    }

    override fun getPinById(id: Long): Pin {
        return pinDao.getById(id)
    }

    override fun removePinById(id: Long): Pin {
        return pinDao.removeById(id)
    }

    override fun getPinByApiToken(api_token: String): Pin {
        return pinDao.getPinByApiToken(api_token)
    }

}