package nl.hva.mediacentre;

import nl.hva.Recordings.Recording;
import nl.hva.codecs.Codec;

/**
 * A class for demonstrating the strategy pattern.  A nl.hva.mediacentre.MediaCentre can play and record files as
 * long as it has the correct Codec.  It can only have one Codec at a time.
 */
public class MediaCentre {
    private Codec codec;
    private String status;
    public static final String NO_DECODER = "On but no decoder available";
    public static final String DECODER_SET = "On and decoder available: ";
    public static final String INCORRECT_DECODER_FOR_PLAYING = "Incorrect decoder for playing file";

    /**
     * Creates a nl.hva.mediacentre.MediaCentre with initially no Codec
     */
    public MediaCentre() {

        //TODO
    }

    /**
     * Set the current Codec.  The Codec can be set to null. When the
     * Codec is set the status should be: DECODER_SET+codec.getFileType() else
     * status is: NO_DECODER
     *
     * @param codec a Codec
     */

    public void setCodec(Codec codec) {
        //TODO

    }

    /**
     * Play a Recording.  The recording will only play if the required Codec is available.
     * The type of Codec required is deduced from the FileType of the Recording
     *
     * @param recording a Recording
     * @return status in the form of either the message returned from the Codec or
     * nl.hva.mediacentre.MediaCentre.INCORRECT_DECODER_FOR_PLAYING
     */
    public String playFile(Recording recording) {
        //TODO
        return null;
    }

    /**
     * Record a file with the title passed in.  The Recording will be of the type matching the current Codec
     * if there is one.  If there is no Codec set then null will be returned.
     *
     * @param title - a title for the Recording
     * @return a new Recording with the title and current Codec format
     */
    public Recording recordFile(String title) {
        //TODO
        return null;

    }

    /**
     * Get the status message of this nl.hva.mediacentre.MediaCentre
     *
     * @return status
     */
    public String getStatus() {

        //TODO
        return null;
    }
}
