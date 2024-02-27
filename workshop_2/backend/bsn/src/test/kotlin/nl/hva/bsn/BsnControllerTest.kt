package nl.hva.bsn

import nl.hva.bsn.exceptions.ApiException
import nl.hva.bsn.validators.BsnValidator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
@Import(TestConfig::class)
class BsnControllerTest {

    private var validBsn: String = "54321098"
    private var invalidBsn: String = "000"

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var bsnValidator: BsnValidator

    @BeforeEach
    fun setup() {
        bsnValidator = Mockito.mock(BsnValidator::class.java)
        Mockito.`when`(bsnValidator.validate(validBsn)).thenReturn(true)
        Mockito.`when`(bsnValidator.validate(invalidBsn)).thenReturn(false)
    }

    @Test
    fun `valid bsn should return 200 OK`() {
        mockMvc.perform(
            post("/v1/bsn/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"bsn\": \"$validBsn\"}")
        ).andExpect(status().isOk)
            .andExpect(jsonPath("$.valid").value(true))
    }

    @Test
    fun `invalid bsn should throw ApiException`() {
        mockMvc.perform(
            post("/v1/bsn/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"bsn\": \"$invalidBsn\"}")
        ).andExpect { result -> Assertions.assertTrue(result.resolvedException is ApiException) }
            .andExpect(jsonPath("$.status").value(400))
            .andExpect(jsonPath("$.message").exists())
    }

    @Test
    fun `invalid body should return 400 Bad Request`() {
        mockMvc.perform(
            post("/v1/bsn/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{}")
        ).andExpect(status().isBadRequest)
    }


}

@Configuration
class TestConfig {

    @Bean
    fun bsnValidator() = BsnValidator()

}