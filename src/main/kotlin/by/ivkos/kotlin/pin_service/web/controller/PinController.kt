package by.ivkos.kotlin.pin_service.web.controller

import by.ivkos.kotlin.pin_service.domain.Pin
import by.ivkos.kotlin.pin_service.service.PinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/pins")
open class PinController {

    @Autowired
    lateinit var pinService: PinService

    @RequestMapping(value = "/add", method = arrayOf(RequestMethod.POST),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ResponseBody
    open fun createPin(@RequestBody pin: Pin): Pin {
        val random: Random = Random()
        pin.code = random.nextInt(10000)
        pinService.addPin(pin)
        return pin
    }

    @RequestMapping(value = "/{api_token}/check", method = arrayOf(RequestMethod.POST))
    open fun checkPin(@PathVariable api_token: String, @RequestHeader code: Int): String {
        var pin: Pin? = pinService.getPinByApiToken(api_token)
        if (pin?.code!!.equals(code)) {
            return "success"
        }
        return "fail"
    }

}