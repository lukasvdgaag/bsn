package nl.hva.bsn.exceptions

import nl.hva.bsn.constants.ApiError

class ApiException(
    val error: ApiError
) : Exception(error.message)