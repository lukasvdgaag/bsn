package nl.hva.bsn

import nl.hva.bsn.validators.BsnValidator
import nl.hva.bsn.validators.ElevenTestValidator
import nl.hva.bsn.validators.LengthValidator
import nl.hva.bsn.validators.NumericValidator
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

        Assertions.assertFalse(elevenTestValidator.validate(invalidBsn), "BSN $invalidBsn should be invalid")
    }

    companion object {
        lateinit var elevenTestValidator: BsnValidator
        lateinit var lengthValidator: BsnValidator
        lateinit var numericValidator: BsnValidator

        @JvmStatic
        @BeforeAll
        fun setUp() {
            lengthValidator = LengthValidator()
            numericValidator = NumericValidator()
            elevenTestValidator = ElevenTestValidator()
        }
    }


}
