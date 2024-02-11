package nl.hva.codecs;

public class MP3Codec extends AbstractCodec {

    public MP3Codec() {
        super(FileType.MP3);
    }

    @Override
    public String getCodecInformation() {
        return CodecDescriptions.MP3_DESCRIPTION;
    }
}
