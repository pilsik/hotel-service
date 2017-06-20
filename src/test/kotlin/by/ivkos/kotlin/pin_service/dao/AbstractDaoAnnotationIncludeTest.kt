package by.ivkos.kotlin.pin_service.dao

import by.ivkos.kotlin.pin_service.HotelServiceApplication
import com.github.springtestdbunit.DbUnitTestExecutionListener
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests

@TestExecutionListeners(DbUnitTestExecutionListener::class)
@SpringBootTest(classes = arrayOf(HotelServiceApplication::class))
@DirtiesContext
open class AbstractDaoAnnotationIncludeTest : AbstractTransactionalJUnit4SpringContextTests()