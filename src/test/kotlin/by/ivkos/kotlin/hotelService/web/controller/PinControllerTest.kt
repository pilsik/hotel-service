package by.ivkos.kotlin.hotelService.web.controller

import by.ivkos.kotlin.hotelService.HotelServiceApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(HotelServiceApplication::class))
@WebAppConfiguration
class PinControllerTest {

    lateinit var mockMvc: MockMvc

    @Autowired
    @InjectMocks
    lateinit var controller: PinController

    @Before
    fun setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setMessageConverters(MappingJackson2HttpMessageConverter()).build()
    }

    @Test
    fun allHotels() {

    }

    @Test
    fun getHotel() {

    }

    @Test
    fun getHotelRoom() {

    }

}