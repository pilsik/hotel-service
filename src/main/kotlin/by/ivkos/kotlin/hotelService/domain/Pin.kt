package by.ivkos.kotlin.hotelService.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pins")
data class Pin(
        @Id @GeneratedValue var id_pin: Long = 0,
        var api_token: String = "",
        var operation_id: String = "",
        var email: String = "",
        var code : Long = 0)

