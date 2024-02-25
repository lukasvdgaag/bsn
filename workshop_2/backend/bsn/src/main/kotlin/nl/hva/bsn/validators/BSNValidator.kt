package nl.hva.bsn.validators

class BSNValidator : Validator {

    override fun validate(bsn: String): Boolean {
        return ValidationBuilder()
            .with(LengthValidator())
            .with(NumericValidator())
            .with(ElevenTestValidator())
            .build()
            .validate(bsn)
    }
}