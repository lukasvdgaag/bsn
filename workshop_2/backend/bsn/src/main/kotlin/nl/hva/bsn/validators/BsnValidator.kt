package nl.hva.bsn.validators

@FunctionalInterface
interface BsnValidator {

    /**
     * Validates the given BSN
     * @param bsn the BSN to validate
     * @return true if the BSN is valid, false otherwise
     */
    fun validate(bsn: String): Boolean

}