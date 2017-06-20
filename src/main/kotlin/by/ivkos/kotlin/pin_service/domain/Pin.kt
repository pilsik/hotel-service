package by.ivkos.kotlin.pin_service.domain

import javax.persistence.*

@Entity
@Table(name = "pins")
data class Pin(
        @Id
        @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "pins_sequence")
        @SequenceGenerator(name = "pins_sequence", sequenceName = "pins_seq")
        var id_pin: Long = 0,
        var api_token: String = "",
        var operation_id: String = "",
        var email: String = "",
        var code: Int = 0,
        var timestamp: Long = System.currentTimeMillis())

