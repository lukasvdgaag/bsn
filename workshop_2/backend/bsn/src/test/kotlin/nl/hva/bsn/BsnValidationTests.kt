package nl.hva.bsn

import nl.hva.bsn.constants.ApiError
import nl.hva.bsn.exceptions.ApiException
import nl.hva.bsn.validators.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BsnValidationTests {

    @Test
    fun `BSN of 8 or 9 digits should be valid`() {
        val eightCharBsn = "12345678"
        val nineCharBsn = "123456789"

        println("test")

        Assertions.assertTrue(lengthValidator.validate(eightCharBsn), "BSN $eightCharBsn should be valid")
        Assertions.assertTrue(lengthValidator.validate(nineCharBsn), "BSN $nineCharBsn should be valid")
    }

    @Test
    fun `BSN of less than 8 or more than 9 digits should be invalid`() {
        val sevenCharBsn = "1234567"
        val tenCharBsn = "1234567890"

        val exception = Assertions.assertThrows(ApiException::class.java) { lengthValidator.validate(sevenCharBsn) }
        Assertions.assertEquals(ApiError.BSN_INVALID_LENGTH, exception.error, "BSN $sevenCharBsn should be invalid")

        val exception2 = Assertions.assertThrows(ApiException::class.java) { lengthValidator.validate(tenCharBsn) }
        Assertions.assertEquals(ApiError.BSN_INVALID_LENGTH, exception2.error, "BSN $tenCharBsn should be invalid")
    }

    @Test
    fun `BSN should be numeric`() {
        val numericBsn = "123456789"

        Assertions.assertTrue(numericValidator.validate(numericBsn), "BSN $numericBsn should be valid")
    }

    @Test
    fun `BSN should not be non-numeric`() {
        val nonNumericBsn = "12345678a"

        val exception = Assertions.assertThrows(ApiException::class.java) { numericValidator.validate(nonNumericBsn) }
        Assertions.assertEquals(ApiError.BSN_INVALID_FORMAT, exception.error, "BSN $nonNumericBsn should be invalid because it contains non-numeric characters")
    }

    @Test
    fun `BSN should pass the 11-test`() {
        val validBsnNineChars = "752311359"
        val validBsnEightChars = "54321098"
        val validBsnEightCharsPadded = "054321098"

        Assertions.assertTrue(elevenTestValidator.validate(validBsnNineChars), "BSN $validBsnNineChars should be valid")
        Assertions.assertTrue(
            elevenTestValidator.validate(validBsnEightChars),
            "BSN $validBsnEightChars should be valid because it should be padded with a zero"
        )
        Assertions.assertTrue(
            elevenTestValidator.validate(validBsnEightCharsPadded),
            "BSN $validBsnEightCharsPadded should be valid because it should be padded with a zero"
        )
    }

    @Test
    fun `Invalid BSN should not pass the 11-test`() {
        val invalidBsn = "123456789"

        val exception = Assertions.assertThrows(ApiException::class.java) { elevenTestValidator.validate(invalidBsn) }
        Assertions.assertEquals(ApiError.BSN_FAILED_ELEVEN_TEST, exception.error, "BSN $invalidBsn should be invalid because it fails the 11-test")
    }

    @Test
    fun `BSN should be valid`() {
        val validBsn = "182015737"
        val validBsn2 = "54321098"

        Assertions.assertTrue(bsnValidator.validate(validBsn), "BSN $validBsn should be valid")
        Assertions.assertTrue(bsnValidator.validate(validBsn2), "BSN $validBsn2 should be valid")
    }

    @Test
    fun `BSN should be invalid`() {
        val invalidBsn = "12345678"
        val invalidBsn2 = "1234567890"
        val invalidBsn3 = "12345678a"

        Assertions.assertThrows(ApiException::class.java, { bsnValidator.validate(invalidBsn) }, "BSN $invalidBsn should be invalid")
        Assertions.assertThrows(ApiException::class.java, { bsnValidator.validate(invalidBsn2) }, "BSN $invalidBsn2 should be invalid")
        Assertions.assertThrows(ApiException::class.java, { bsnValidator.validate(invalidBsn3) }, "BSN $invalidBsn3 should be invalid")
    }

    companion object {
        lateinit var elevenTestValidator: Validator
        lateinit var lengthValidator: Validator
        lateinit var numericValidator: Validator
        lateinit var bsnValidator: Validator

        @JvmStatic
        @BeforeAll
        fun setUp() {
            lengthValidator = LengthValidator(BsnValidator.BSN_MIN_LENGTH, BsnValidator.BSN_MAX_LENGTH)
            numericValidator = NumericValidator()
            elevenTestValidator = ElevenTestValidator()
            bsnValidator = BsnValidator()
        }
    }


}
