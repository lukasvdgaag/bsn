package nl.hva.codecs;

public class AIFFCodec extends AbstractCodec {

    public AIFFCodec() {
        super(FileType.AIFF);
    }

    @Override
    public String getCodecInformation() {
        return CodecDescriptions.AIFF_DESCRIPTION;
    }
}
