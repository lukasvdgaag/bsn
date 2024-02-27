package nl.hva.bsn.validators

import nl.hva.bsn.constants.ApiError
import nl.hva.bsn.exceptions.ApiException

class NumericValidator : Validator {

    override fun validate(bsn: String): Boolean {
        if (!bsn.matches(Regex("\\d+"))) {
            throw ApiException(ApiError.BSN_INVALID_FORMAT)
        }
        return true
    }

}