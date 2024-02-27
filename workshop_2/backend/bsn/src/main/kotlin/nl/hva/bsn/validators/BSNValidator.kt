package nl.hva.bsn.validators

class BSNValidator : Validator by ValidationBuilder()
        .with(LengthValidator(BSN_MIN_LENGTH, BSN_MAX_LENGTH))
        .with(NumericValidator())
        .with(ElevenTestValidator())
        .build() {

    companion object {
        const val BSN_MIN_LENGTH = 8
        const val BSN_MAX_LENGTH = 9
    }

}