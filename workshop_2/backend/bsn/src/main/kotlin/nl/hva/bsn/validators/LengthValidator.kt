package nl.hva.bsn.validators

/**
 * Validates the length of a BSN
 * The length of a BSN should be 8 or 9
 */
class LengthValidator(
    private val minLength: Int,
    private val maxLength: Int,
) : Validator {

    override fun validate(bsn: String): Boolean {
        return bsn.length in minLength..maxLength
    }

}