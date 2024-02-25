package nl.hva.bsn.validators

class NumericValidator : BsnValidator {

    override fun validate(bsn: String): Boolean {
        return bsn.matches(Regex("\\d+"))
    }

}