package assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KnuthMorrisPratt {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
        	

        	ArrayList list = new ArrayList<>();
        	
        	list .add(2);
        	list.add("hello");
        	
        	System.out.println(list.get(0) instanceof Object);
        	System.out.println(list.get(1));

            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    // Find all the occurrences of the pattern in the text and return
    // a list of all positions in the text (starting from 0) where
    // the pattern starts in the text.
    public List<Integer> findPattern(String pat, String txt) {
        

        ArrayList<Integer> matches = new ArrayList<Integer>();
        if (txt == null || pat == null)
            return matches;

        int m = pat.length(), n = txt.length(), i = 0, j = 0;
        
        if (m > n) 
        		return matches;

        int[] arr = kmpHelper(pat, m);

        while (i < n) {
          if (pat.charAt(j) == txt.charAt(i)) {
            j++;
            i++;
          }
          if (j == m) {
            matches.add(i - j);
            j = arr[j - 1];
          } 
          else if (i < n && pat.charAt(j) != txt.charAt(i)) {
            if (j != 0) 
            		j = arr[j - 1];
            else 
            		i = i + 1;
          }
        }

        return matches;
      }

      // For each index i compute the longest match between the proper
      // prefix starting at 0 and the proper suffix starting at i
      private static int[] kmpHelper(String pat, int m) {
        int[] arr = new int[m];
        for (int i = 1, len = 0; i < m; ) {
          if (pat.charAt(i) == pat.charAt(len)) {
            arr[i++] = ++len;
          } else {
            if (len > 0) 
            		len = arr[len - 1];
            else 
            		i++;
          }
        }
        return arr;
      }

    static public void main(String[] args) throws IOException {
        new KnuthMorrisPratt().run();
    }

    public void print(List<Integer> x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String pattern = scanner.next();
        String text = scanner.next();
        List<Integer> positions = findPattern(pattern, text);
        print(positions);
    }
}
