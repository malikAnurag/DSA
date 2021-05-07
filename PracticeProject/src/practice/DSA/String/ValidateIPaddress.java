package practice.DSA.String;

/**
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging
 * from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups
 * are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we
 * could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones,
 * so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 *
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::)
 * to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334
 * is invalid.
 *
 * Example 1:
 *
 * Input: IP = "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 *
 * Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 *
 * Input: IP = "256.256.256.256"
 * Output: "Neither"
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
public class ValidateIPaddress {

    public static void main(String[] args) {

        System.out.println(validIPAddress("172.16.254.1"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("256.256.256.256"));

    }

    public static String validIPAddress(String IP) {

        int dots = 0 ;
        int colon = 0;

        for(char c : IP.toCharArray()) {
            if(c == '.')
                dots++;
            else if(c == ':')
                colon++;
        }

        if(dots != 3 && colon != 7)
            return "Neither";

        if(dots == 3) {
            String[] arr = IP.split("\\.");

            if(arr.length < 4)
                return "Neither";

            for(String s : arr) {

                if(s.length() == 0 || s.length() > 3)
                    return "Neither";
                if(s.charAt(0) == '0' && s.length() != 1)
                    return "Neither";

                for(char x : s.toCharArray()) {
                    if(!Character.isDigit(x)) {
                        return "Neither";
                    }
                }

                int num = Integer.parseInt(s);
                if(num > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        }

        else if(colon == 7) {
            String[] arr = IP.split(":");
            if(arr.length < 8)
                return "Neither";
            for(String s : arr) {
                if(s.length() == 0 || s.length() > 4)
                    return "Neither";
                for(char x : s.toCharArray()) {
                    boolean flag = isHexaDecimal(String.valueOf(x));
                    if(!flag) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        return null;
    }

    public static boolean isHexaDecimal(String str) {

        try {
            Long.parseLong(str, 16);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
