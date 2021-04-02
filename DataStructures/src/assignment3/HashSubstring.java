package assignment3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

	private static FastScanner in;
	private static PrintWriter out;
	public final static int d = 256; 

	public static void main(String[] args) throws IOException {
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		printOccurrences(getOccurrences(readInput()));
		out.close();
	}

	private static Data readInput() throws IOException {
		String pattern = in.next();
		String text = in.next();
		return new Data(pattern, text);
	}

	private static void printOccurrences(List<Integer> ans) throws IOException {
		for (Integer cur : ans) {
			out.print(cur);
			out.print(" ");
		}
	}

	private static List<Integer> getOccurrences(Data input) {
		return search(input.pattern, input.text, 101);
	}

	static List<Integer> search(String pat, String txt, int q) 
    { 
		List<Integer> occurrences = new ArrayList<Integer>();
        int M = pat.length(); 
        int N = txt.length(); 
        int i, j; 
        int p = 0; // hash value for pattern 
        int t = 0; // hash value for txt 
        int h = 1; 
      
        // The value of h would be "pow(d, M-1)%q" 
        for (i = 0; i < M-1; i++) 
            h = (h*d)%q; 
      
        // Calculate the hash value of pattern and first 
        // window of text 
        for (i = 0; i < M; i++) 
        { 
            p = (d*p + pat.charAt(i))%q; 
            t = (d*t + txt.charAt(i))%q; 
        } 
      
        // Slide the pattern over text one by one 
        for (i = 0; i <= N - M; i++) 
        { 
      
            // Check the hash values of current window of text 
            // and pattern. If the hash values match then only 
            // check for characters on by one 
            if ( p == t ) 
            { 
                /* Check for characters one by one */
                for (j = 0; j < M; j++) 
                { 
                    if (txt.charAt(i+j) != pat.charAt(j)) 
                        break; 
                } 
      
                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1] 
                if (j == M) 
                	occurrences.add(i);
            } 
      
            // Calculate hash value for next window of text: Remove 
            // leading digit, add trailing digit 
            if ( i < N-M ) 
            { 
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q; 
      
                // We might get negative value of t, converting it 
                // to positive 
                if (t < 0) 
                t = (t + q); 
            } 
        } 
        return occurrences;
    } 
	
	
	
	static class Data {
		String pattern;
		String text;

		public Data(String pattern, String text) {
			this.pattern = pattern;
			this.text = text;
		}
	}

	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
