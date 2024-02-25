package nl.hva.bsn.validators

/**
 * Validates the length of a BSN
 * The length of a BSN should be 8 or 9
 */
class LengthValidator : BsnValidator {

    override fun validate(bsn: String): Boolean {
        return bsn.length == 8 || bsn.length == 9
    }

}