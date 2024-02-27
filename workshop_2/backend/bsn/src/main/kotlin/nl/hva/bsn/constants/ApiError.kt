package nl.hva.bsn.constants

import nl.hva.bsn.validators.BsnValidator

enum class ApiError(val message: String, val status: Int = 400) {

    BSN_INVALID_LENGTH("BSN must be ${BsnValidator.BSN_MIN_LENGTH} or ${BsnValidator.BSN_MAX_LENGTH} characters long"),
    BSN_INVALID_FORMAT("BSN must only contain numeric characters"),
    BSN_FAILED_ELEVEN_TEST("BSN failed the eleven test")

}