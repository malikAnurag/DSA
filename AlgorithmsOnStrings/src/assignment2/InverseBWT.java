package assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InverseBWT {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    String inverseBWT(String bwt) {
        StringBuilder result = new StringBuilder();

        Integer[] indices = new Integer[bwt.length()];

        for (int i = 0; i < bwt.length(); i++)
            indices[i] = i;

        java.util.Arrays.sort(indices, new BWTComparator(bwt));

        int startIndex = 0;
        for (; bwt.charAt(startIndex) != '$'; ++startIndex) ;


        for (int i = 0; i < indices.length - 1; ++i) {
            startIndex = indices[startIndex];
            char c = bwt.charAt(startIndex);
            result.append(c);
        }
        result.append('$');
        return result.toString();
    }

    public static class BWTComparator implements java.util.Comparator<Integer> {
        private final String string;

        BWTComparator(String string) {
            this.string = string;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return string.charAt(o1) - string.charAt(o2);
        }

        public boolean equals(Integer i1, Integer i2) {
            return string.charAt(i1) == string.charAt(i2);
        }
    }

    static public void main(String[] args) throws IOException {
        new InverseBWT().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String bwt = scanner.next();
        System.out.println(inverseBWT(bwt));
    }
}
