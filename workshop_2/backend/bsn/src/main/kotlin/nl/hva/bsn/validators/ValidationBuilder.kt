package nl.hva.bsn.validators

/**
 * This class is used to build a BsnValidator object. It uses the Builder design pattern.
 * The BsnValidator object is used to validate a BSN (Burger Service Nummer, a Dutch national identification number).
 * The builder allows to chain multiple validation rules and build a BsnValidator that applies all these rules.
 *
 * Usage example:
 * val validator = ValidationBuilder()
 *     .with(firstValidator)
 *     .with(secondValidator)
 *     .build()
 */
class ValidationBuilder {

    private var validator: BsnValidator? = null

    /**
     * This method is used to add a new validator to the chain of validators.
     * If there is no validator yet, it sets the provided validator as the current one.
     * If there already is a validator, it creates a new validator that applies both the current and the provided validators.
     *
     * @param validator The validator to be added to the chain.
     * @return The builder itself, to allow method chaining.
     */
    fun with(validator: BsnValidator): ValidationBuilder {
        if (this.validator == null) {
            this.validator = validator
        } else {
            this.validator = BsnValidator { bsn -> this.validator!!.validate(bsn) && validator.validate(bsn) }
        }
        return this
    }

    /**
     * This method is used to build the final BsnValidator.
     * If no validator was added, it returns a validator that always returns true.
     *
     * @return The final BsnValidator.
     */
    fun build(): BsnValidator {
        return validator ?: BsnValidator { _ -> true }
    }

}