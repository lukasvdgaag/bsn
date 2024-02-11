package nl.hva.codecs;

public class WAVCodec extends AbstractCodec {

    public WAVCodec() {
        super(FileType.WAV);
    }

    @Override
    public String getCodecInformation() {
        return CodecDescriptions.WAV_DESCRIPTION;
    }
}
