import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpellChecker {  
    public static void main(String[] args) {
        
    		List<String> dictionary = new ArrayList<String>();
        
    		dictionary.add("Airtel");dictionary.add("GSM");dictionary.add("4G");dictionary.add("Communication");dictionary.add("Telecom");dictionary.add("Bharti");
    		
    		Scanner scan = new Scanner(System.in);
    		System.out.println("Do you want to refresh the dictionary (Y/N)?");
    		try{
    			char c = scan.next(".").charAt(0);
    			if(c == 'N' || c == 'n') {
        			System.out.println("Enter the word to find: ");
        			scan.nextLine();
        			String str = scan.nextLine().replaceAll(" ", "");
        			System.out.println("\nResult: "+checkSpelling(dictionary, str));
        		}
        		else if(c =='Y' || c == 'y') {
        			System.out.println("\nHow many words do you want to add?");
        			int n = scan.nextInt();
        			System.out.println("\nEnter the words below:");
        			while(n>=0) {
        				String newWord = scan.nextLine();
        				if(!newWord.isEmpty())
        					dictionary.add(newWord.replaceAll(" ", ""));
        				n--;
        			}
        			System.out.println("\nEnter the word to find: ");
        			String str = scan.nextLine().replaceAll(" ", "");
        			System.out.println("\nResult: "+checkSpelling(dictionary, str));
        		}else {
        			System.out.println("\nInvalid Input! Please try again.");
        		}
    		}catch(Exception e) {
    			System.out.println("\nInvalid Input! Please try again.");
    		}
    }
    
    public static String checkSpelling(List<String> dictionary, String str) {

    	for(int i = 0 ; i<dictionary.size() ; i++)
    		dictionary.set(i, dictionary.get(i).toLowerCase());
    	
    	System.out.println("\nDictionary: ");
    	for(String s : dictionary)
    		System.out.print(s+" ");
    	System.out.println();
    	
    		if(dictionary.contains(str.toLowerCase()))
    			return "FOUND";
    		else
    			return "NOT FOUND";
    	
    }
}
