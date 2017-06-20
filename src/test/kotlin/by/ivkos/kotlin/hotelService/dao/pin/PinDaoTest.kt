package by.ivkos.kotlin.hotelService.dao.pin

import by.ivkos.kotlin.hotelService.dao.AbstractDaoAnnotationIncludeTest
import by.ivkos.kotlin.hotelService.domain.Pin
import com.github.springtestdbunit.annotation.DatabaseOperation
import com.github.springtestdbunit.annotation.DatabaseSetup
import com.github.springtestdbunit.annotation.DatabaseTearDown
import org.hamcrest.Matchers.*
import org.junit.Assert.assertThat
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired


@DatabaseSetup(PinDaoTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = PinDaoTest.DATASET)
open class PinDaoTest : AbstractDaoAnnotationIncludeTest() {

    @Autowired
    lateinit var pinDao: PinDao

    @Test
    fun findsAndReadsExistingPersonById() {
        val pin: Pin = pinDao.getById(PIN_ID_1)
        assertThat(pin.id_pin, `is`(PIN_ID_1))
        assertThat(pin.code, `is`(PIN_CODE_1))
        assertThat(pin.email, `is`(PIN_EMAIL_1))
        assertThat(pin.api_token, `is`(API_TOKEN_1))
    }

    @Test
    fun finsdOnePinByApiToken() {
        val pin: Pin = pinDao.getPinByApiToken(API_TOKEN_2)
        assertThat(pin.id_pin, `is`(PIN_ID_2))
    }


    companion object {
        const val DATASET = "classpath:datasets/pin-table.xml"
        private val PIN_ID_1: Long = 100000
        private val PIN_CODE_1: Long = 123123
        private val PIN_EMAIL_1: String = "EMAIL_1"
        private val API_TOKEN_1: String = "API_TOKEN_1"
        private val API_TOKEN_2: String = "API_TOKEN_2"
        private val PIN_ID_2: Long = 100001
    }
}