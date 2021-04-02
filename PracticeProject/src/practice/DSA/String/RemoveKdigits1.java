package practice.DSA.String;

public class RemoveKdigits1 {

    public static void main(String[] args) {

        String A = "1432219";
        int n = 3;

        StringBuilder sb = new StringBuilder();

        removeDigits(sb, A, n);

        if(!sb.equals("")) {

            // To remove all the leading zeroes
            int i = 0;
            while(i < sb.length() && sb.charAt(i) == '0')
                i++;

            sb = sb.replace(0, i, "");

            System.out.println(sb);
        }
        else
            System.out.println("0");
    }

    public static void removeDigits(StringBuilder sb, String num, int n) {

        if(n == 0) {
            sb.append(num);
            return;
        }
        else if(n == num.length())
            return;

        int minIndex = 0;
        for(int i = 1 ; i <= n ; i++) {
            if(num.charAt(i) < num.charAt(minIndex))
                minIndex = i;
        }
        sb.append(num.charAt(minIndex));
        num  = num.substring(minIndex+1);
        removeDigits(sb, num, n-minIndex);
    }
}
