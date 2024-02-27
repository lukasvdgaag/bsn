package nl.hva.bsn.exceptions

import jakarta.servlet.http.HttpServletResponse
import nl.hva.bsn.constants.ApiError
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ApiException::class)
    fun handleApiException(
        ex: ApiException,
        response: HttpServletResponse,
    ): ResponseEntity<ServiceError> {
        return createResponse(
            status = HttpStatus.valueOf(ex.error.status),
            message = ex.error.message,
        )
    }

    fun createResponse(
        message: String,
        status: HttpStatus
    ): ResponseEntity<ServiceError> =
        ResponseEntity
            .status(status)
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                ServiceError(
                    status = status.value(),
                    message = message,
                )
            )

    data class ServiceError(
        val status: Int,
        val message: String
    )

}