package nl.hva.bsn.controllers

import nl.hva.bsn.requests.BsnValidationRequest
import nl.hva.bsn.responses.ValidationResponse
import nl.hva.bsn.validators.BsnValidator
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/v1/bsn")
class BsnController(
    private val bsnValidator: BsnValidator
) {

    @PostMapping("/validate")
    fun validateBSN(@RequestBody request: BsnValidationRequest): ResponseEntity<ValidationResponse> {
        val isValid = bsnValidator.validate(request.bsn)

        return ResponseEntity.ok(ValidationResponse(isValid))
    }

}