package nl.hva.bsn

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

        Assertions.assertTrue(lengthValidator.validate(eightCharBsn), "BSN $eightCharBsn should be valid")
        Assertions.assertTrue(lengthValidator.validate(nineCharBsn), "BSN $nineCharBsn should be valid")
    }

    @Test
    fun `BSN should be numeric`() {
        val numericBsn = "123456789"

        Assertions.assertTrue(numericValidator.validate(numericBsn), "BSN $numericBsn should be valid")
    }

    @Test
    fun `BSN should not be non-numeric`() {
        val nonNumericBsn = "12345678a"

        Assertions.assertFalse(numericValidator.validate(nonNumericBsn), "BSN $nonNumericBsn should be invalid because it contains non-numeric characters")
    }

    @Test
    fun `BSN should pass the 11-test`() {
        val validBsnNineChars = "752311359"
        val validBsnEightChars = "12345671"

        Assertions.assertTrue(elevenTestValidator.validate(validBsnNineChars), "BSN $validBsnNineChars should be valid")
        Assertions.assertTrue(
            elevenTestValidator.validate(validBsnEightChars),
            "BSN $validBsnEightChars should be valid because it should be padded with a zero"
        )
    }

    @Test
    fun `Invalid BSN should not pass the 11-test`() {
        val invalidBsn = "123456789"

        Assertions.assertFalse(elevenTestValidator.validate(invalidBsn), "BSN $invalidBsn should be invalid")
    }

    companion object {
        var elevenTestValidator: BsnValidator = TODO()
        var lengthValidator: BsnValidator = TODO()
        var numericValidator: BsnValidator = TODO()

        @JvmStatic
        @BeforeAll
        fun setUp(): Unit {
            lengthValidator = LenghtValidator()
            numericValidator = NumericValidator()
            elevenTestValidator = ElevenTestValidator()
        }
    }


}
