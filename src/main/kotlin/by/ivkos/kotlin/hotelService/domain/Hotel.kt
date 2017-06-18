package by.ivkos.kotlin.hotelService.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "hotels")
data class Hotel(
        @Id @GeneratedValue var id: Long = 0,
        var name: String= "default",
        var capacity: Long = 0)

