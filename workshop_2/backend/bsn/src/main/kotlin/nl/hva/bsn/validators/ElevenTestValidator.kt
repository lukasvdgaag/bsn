package nl.hva.bsn.validators

import nl.hva.bsn.constants.ApiError
import nl.hva.bsn.exceptions.ApiException

/**
 * This class is used to validate a BSN (Burger Service Nummer, a Dutch national identification number).
 * It applies an adaption of the 11-test to the BSN.
 */
class ElevenTestValidator : Validator {

    companion object {
        private const val MIN_LENGTH = 8
        private const val MAX_LENGTH = 9
    }

    override fun validate(bsn: String): Boolean {
        val finalBsn = if (bsn.length == MIN_LENGTH) "0$bsn" else bsn

        val sum = finalBsn.withIndex().sumOf { (index, char) ->
            if (index < MAX_LENGTH - 1)
                (MAX_LENGTH - index) * char.digitToInt()
            else
                -1 * char.digitToInt()
        }

        if (sum % 11 != 0) {
            throw ApiException(ApiError.BSN_FAILED_ELEVEN_TEST)
        }
        return true
    }
}