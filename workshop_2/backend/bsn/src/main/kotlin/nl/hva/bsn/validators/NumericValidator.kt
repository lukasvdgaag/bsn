package nl.hva.bsn.validators

class NumericValidator : Validator {

    override fun validate(bsn: String): Boolean {
        return bsn.matches(Regex("\\d+"))
    }

}