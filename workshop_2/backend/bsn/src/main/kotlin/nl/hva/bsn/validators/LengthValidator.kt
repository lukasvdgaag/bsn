package nl.hva.bsn.validators

import nl.hva.bsn.constants.ApiError
import nl.hva.bsn.exceptions.ApiException

/**
 * Validates the length of a BSN
 * The length of a BSN should be 8 or 9
 */
class LengthValidator(
    private val minLength: Int,
    private val maxLength: Int,
) : Validator {

    override fun validate(bsn: String): Boolean {
        if (bsn.length !in minLength..maxLength) {
            throw ApiException(ApiError.BSN_INVALID_LENGTH)
        }
        return true
    }

}