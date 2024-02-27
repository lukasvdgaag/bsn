package nl.hva.bsn.validators

import org.springframework.stereotype.Service

@Service
class BsnValidator : Validator by ValidationBuilder()
        .with(LengthValidator(BSN_MIN_LENGTH, BSN_MAX_LENGTH))
        .with(NumericValidator())
        .with(ElevenTestValidator())
        .build() {

    companion object {
        const val BSN_MIN_LENGTH = 8
        const val BSN_MAX_LENGTH = 9
    }

}