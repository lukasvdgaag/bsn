package nl.hva.codecs;

public class AACCodec extends AbstractCodec {

    public AACCodec() {
        super(FileType.AAC);
    }

    @Override
    public String getCodecInformation() {
        return CodecDescriptions.AAC_DESCRIPTION;
    }
}
