package nl.hva.codecs;

import nl.hva.Recordings.Recording;

public abstract class AbstractCodec implements Codec {

    protected final FileType fileType;

    public AbstractCodec(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public FileType getFileType() {
        return fileType;
    }

    @Override
    public Recording encode(String title) {
        return new Recording("Decoding " + getFileType().ext, this.getFileType());
    }

    @Override
    public String decode() {
        return "Decoding " + getFileType().ext;
    }

}
