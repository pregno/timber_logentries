package timber.log.logentries;

import java.util.ArrayList;
import java.util.UUID;

public class Utils {

    private Utils() {
    }

    public static boolean checkValidUUID(String uuid) {
        if (uuid != null && !uuid.isEmpty()) {
            try {

                UUID u = UUID.fromString(uuid);
                return true;

            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }

    public static String[] splitStringToChunks(String source, int chunkLength) {
        if (chunkLength < 0) {
            throw new IllegalArgumentException("Chunk length must be greater or equal to zero!");
        }

        int srcLength = source.length();
        if (chunkLength == 0 || srcLength <= chunkLength) {
            return new String[]{source};
        }

        ArrayList<String> chunkBuffer = new ArrayList<String>();
        int splitSteps = srcLength / chunkLength + (srcLength % chunkLength > 0 ? 1 : 0);

        int lastCutPosition = 0;
        for (int i = 0; i < splitSteps; ++i) {

            if (i < splitSteps - 1) {
                // Cut out the chunk of the requested size.
                chunkBuffer.add(source.substring(lastCutPosition, lastCutPosition + chunkLength));
            } else {
                // Cut out all that left to the end of the string.
                chunkBuffer.add(source.substring(lastCutPosition));
            }

            lastCutPosition += chunkLength;
        }

        return chunkBuffer.toArray(new String[chunkBuffer.size()]);
    }
}
