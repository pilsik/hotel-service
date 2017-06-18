package by.ivkos.kotlin.hotelService.dao.hotel

import by.ivkos.kotlin.hotelService.dao.AbstractDaoAnnotationIncludeTest
import by.ivkos.kotlin.hotelService.domain.Hotel
import com.github.springtestdbunit.annotation.DatabaseOperation
import com.github.springtestdbunit.annotation.DatabaseSetup
import com.github.springtestdbunit.annotation.DatabaseTearDown
import org.hamcrest.Matchers.*
import org.junit.Assert.assertThat
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired


@DatabaseSetup(HotelDaoTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = HotelDaoTest.DATASET)
open class HotelDaoTest : AbstractDaoAnnotationIncludeTest() {

    @Autowired
    lateinit var hotelDao: HotelDao

    @Test
    fun findsAndReadsExistingPersonByFirstName() {
        val hotel: Hotel = hotelDao.getById(HOTEL_ID_1)
        assertThat(hotel.id, `is`(HOTEL_ID_1))
        assertThat(hotel.capacity, `is`(HOTEL_CAPACITY_1))
        assertThat(hotel.name, `is`(HOTEL_NAME_1))
    }

    companion object {
        const val DATASET = "classpath:datasets/hotel-table.xml"
        private val HOTEL_ID_1: Long = 100000
        private val HOTEL_CAPACITY_1: Long = 350L
        private val HOTEL_NAME_1: String = "HOTEL_NAME_1"
    }
}