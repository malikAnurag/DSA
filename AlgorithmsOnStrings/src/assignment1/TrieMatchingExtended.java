package assignment1;

import java.io.*;
import java.util.*;

class Node1
{
	public static final int Letters =  4;
	public static final int NA      = -1;
	public int next [];
	public boolean patternEnd;

	Node1 ()
	{
		next = new int [Letters];
		Arrays.fill (next, NA);
		patternEnd = false;
	}
}

public class TrieMatchingExtended implements Runnable {
	int letterToIndex (char letter)
	{
		switch (letter)
		{
			case 'A': return 0;
			case 'C': return 1;
			case 'G': return 2;
			case 'T': return 3;
			default: assert (false); return Node.NA;
		}
	}

	List <Integer> solve (String text, int n, List <String> patterns) {
		List<Integer> result = new ArrayList<Integer>();
		TrieMatchingExtended trieMatchingExtended = new TrieMatchingExtended();
		
		String[] patternsArr = new String[patterns.size()];
		int counter=0;
		for(String str : patterns)
			patternsArr[counter++] = str;
		
		List<Node1> trie = trieMatchingExtended.buildTrie(patternsArr);

		for (int i = 0; i < text.length(); i++) {
			Node1 node = trie.get(0);
			int index = i;

			while (index < text.length()) {
				int nextIndex = letterToIndex(text.charAt(index));

				if (node.next[nextIndex] != Node.NA) {
					node = trie.get(node.next[nextIndex]);
					if (node.patternEnd) {
						result.add(i);
						break;
					}

					index++;
				} else {
					break;
				}
			}
		}

		return result;
	}

	List<Node1> buildTrie(String[] patterns) {

		List<Node1> trie = new ArrayList<Node1>();
		trie.add(new Node1());

		for (String pattern : patterns) {
			Node1 node = trie.get(0);

			for (int i = 0; i < pattern.length(); i++) {
				int index = letterToIndex(pattern.charAt(i));

				if (node.next[index] == Node.NA) {
					trie.add(new Node1());
					node.next[index] = trie.size() - 1;
					node = trie.get(trie.size() - 1);
				} else {
					node = trie.get(node.next[index]);
				}
			}

			node.patternEnd = true;
		}
		return trie;
	}

	public void run () {
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
			String text = in.readLine ();
		 	int n = Integer.parseInt (in.readLine ());
		 	List <String> patterns = new ArrayList <String> ();
			for (int i = 0; i < n; i++) {
				patterns.add (in.readLine ());
			}

			List <Integer> ans = solve (text, n, patterns);

			for (int j = 0; j < ans.size (); j++) {
				System.out.print ("" + ans.get (j));
				System.out.print (j + 1 < ans.size () ? " " : "\n");
			}
		}
		catch (Throwable e) {
			e.printStackTrace ();
			System.exit (1);
		}
	}

	public static void main (String [] args) {
		new Thread (new TrieMatchingExtended ()).start ();
	}
}