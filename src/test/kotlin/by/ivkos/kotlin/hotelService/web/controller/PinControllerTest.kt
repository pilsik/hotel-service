package by.ivkos.kotlin.hotelService.web.controller

import by.ivkos.kotlin.hotelService.HotelServiceApplication
import by.ivkos.kotlin.hotelService.domain.Pin
import by.ivkos.kotlin.hotelService.service.PinService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(HotelServiceApplication::class))
@WebAppConfiguration
class PinControllerTest {

    lateinit var mockMvc: MockMvc

    @Autowired
    @InjectMocks
    lateinit var controller: PinController

    @Mock
    lateinit var mockPinService: PinService

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setMessageConverters(MappingJackson2HttpMessageConverter()).build()
        Mockito.`when`(mockPinService.addPin(PIN)).thenReturn(PIN)
    }

    @Test fun addPin() {
        println(PIN)
        println(jacksonObjectMapper().writeValueAsString(PIN))
        val result: MvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/PinService/pins")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jacksonObjectMapper().writeValueAsString(PIN)))
                .andReturn()
        verify(mockPinService, times(1))
    }

    companion object {
        private val PIN: Pin = Pin(100, "asdasd", "sadasd", "pi-ls@mail.ru", 123123L)
    }

}