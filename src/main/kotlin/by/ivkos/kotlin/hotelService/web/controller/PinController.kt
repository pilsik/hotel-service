package by.ivkos.kotlin.hotelService.web.controller

import by.ivkos.kotlin.hotelService.domain.Pin
import by.ivkos.kotlin.hotelService.service.PinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/pins")
open class PinController {

    @Autowired
    lateinit var pinService: PinService

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    open fun createPin(@RequestBody pin: Pin): Pin {
        val random: Random = Random()
        pin.code = random.nextLong()
        pinService.addPin(pin)
        return pin
    }

    @RequestMapping(value = "/{api_token}/check", method = arrayOf(RequestMethod.POST))
    open fun checkPin(@PathVariable api_token: String, @RequestHeader code: Long): String {
        var pin: Pin? = pinService.getPinByApiToken(api_token)
        if (pin?.code!!.equals(code)) {
            return "success"
        }
        return "fail"
    }

}