package nl.hva.bsn.validators

/**
 * This class is used to validate a BSN (Burger Service Nummer, a Dutch national identification number).
 * It applies an adaption of the 11-test to the BSN.
 */
class ElevenTestValidator : Validator {

    companion object {
        private const val MIN_LENGTH = 8
        private const val MAX_LENGTH = 9
    }

    override fun validate(bsn: String): Boolean {
        val finalBsn = if (bsn.length == MIN_LENGTH) "0$bsn" else bsn

        val sum = finalBsn.withIndex().sumOf { (index, char) ->
            if (index < MAX_LENGTH - 1)
                (MAX_LENGTH - index) * char.digitToInt()
            else
                -1 * char.digitToInt()
        }

        return sum % 11 == 0
    }
}