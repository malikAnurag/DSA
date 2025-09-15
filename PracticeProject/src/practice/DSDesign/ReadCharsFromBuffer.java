package practice.DSDesign;

public class ReadCharsFromBuffer {

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */

    char[] buffer = new char[4];
    int bufferCount = 0;
    int bufferPointer = 0;

    public int read(char[] buf, int n) {

        int totalRead = 0;

        while (totalRead < n) {

            if (bufferPointer == bufferCount) {
                bufferCount = read4(buffer);
                bufferPointer = 0;

                if (bufferCount == 0)
                    break;
            }

            while (totalRead < n && bufferPointer < bufferCount) {
                buf[totalRead++] = buffer[bufferPointer++];
            }
        }
        return totalRead;
    }

    int read4(char[] buf4) {
        // This is just a placeholder. In real use, this reads from the file.
        return 0;
    }
}
