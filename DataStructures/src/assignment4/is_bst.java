package assignment4;

import java.util.*;

import java.io.*;

public class is_bst {
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

    public class IsBST {
    		int n;
		int[] key, left, right;
        
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			inOrderTraversal(result, 0);
			return result;
		}
		
		public void inOrderTraversal(ArrayList<Integer> result, int root) {
			
			if(left[root]!=-1) {
				inOrderTraversal(result,left[root]);
			}
				result.add(key[root]);
				
				if(right[root]!=-1) {
					inOrderTraversal(result,right[root]);
				}
			}
		
        boolean isBinarySearchTree() {
        	
        	if(n == 0)
        		return true;
          
        	List<Integer> inOrderResult = inOrder();
        	boolean isBST = true;

        	for(int i=0 ; i< inOrderResult.size()-1 ; i++)
        	{
        		if(inOrderResult.get(i) > inOrderResult.get(i+1)) {
        			isBST = false;
        			break;
        		}
        	}
          return isBST;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
