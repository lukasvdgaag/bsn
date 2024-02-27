package nl.hva.bsn.validators

class BSNValidator : Validator {

    companion object {
        const val BSN_MIN_LENGTH = 8
        const val BSN_MAX_LENGTH = 9
    }

    private val validator: Validator = ValidationBuilder()
        .with(LengthValidator(BSN_MIN_LENGTH, BSN_MAX_LENGTH))
        .with(NumericValidator())
        .with(ElevenTestValidator())
        .build()

    override fun validate(bsn: String): Boolean {
        return validator.validate(bsn)
    }
}