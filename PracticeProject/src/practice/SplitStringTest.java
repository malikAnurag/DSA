package practice;

public class SplitStringTest {

	public static void main(String[] args) {
		
		//String s = "           YES      leading spaces        are valid,    problemsetters are         evillllll";
		String s ="     ";
		s = s.trim();
		if(s.length()<1)
            System.out.print(0);
        else{
        String[] result = s.split("[!,?._'@ ]+");
        System.out.println(result.length);
        for(int i=0;i<result.length;i++){
            if(i<result.length-1)
                System.out.println(result[i]);
            else
                System.out.print(result[i]);
        }
        }
		
	}

}

/*
8
YES
leading
spaces
are
valid
problemsetters
are
evillllll

*/