package nl.hva.bsn.validators

class ElevenTestValidator : BsnValidator {

    override fun validate(bsn: String): Boolean {
        val finalBsn = if (bsn.length == 8) "0$bsn" else bsn

        var sum = 0
        for (i in 0..7) {
            sum += (9 - i) * finalBsn[i].digitToInt()
        }
        sum += finalBsn[8].digitToInt() * -1

        return sum % 11 == 0
    }
}