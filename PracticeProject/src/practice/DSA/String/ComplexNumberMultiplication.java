package practice.DSA.String;

/**
 * A complex number can be represented as a string on the form "real+imaginaryi" where:
 * real is the real part and is an integer in the range [-100, 100].
 * imaginary is the imaginary part and is an integer in the range [-100, 100].
 * i2 == -1.
 *
 * Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.
 *
 * Example 1:
 * Input: num1 = "1+1i", num2 = "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 *
 * Example 2:
 * Input: num1 = "1+-1i", num2 = "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 *
 * Constraints:
 * num1 and num2 are valid complex numbers.
 */
public class ComplexNumberMultiplication {

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }

    public static String complexNumberMultiply(String num1, String num2) {

        String[] n1 = num1.split("\\+");
        String[] n2 = num2.split("\\+");

        String r1 = n1[0], i1 = n1[1];
        int idx1 = i1.indexOf("i");
        String r2 = n2[0], i2 = n2[1];
        int idx2 = i2.indexOf("i");

        Complex c1 = new Complex(Integer.parseInt(r1), Integer.parseInt(i1.substring(0, idx1)));
        Complex c2 = new Complex(Integer.parseInt(r2), Integer.parseInt(i2.substring(0, idx2)));

        Complex result = new Complex();
        result.real = (c1.real * c2.real) - (c1.img * c2.img);
        result.img = (c1.img * c2.real) + (c2.img * c1.real);

        return result.toString();
    }
}

class Complex {

    int real, img;

    Complex() {}

    Complex(int real, int img) {
        this.real = real;
        this.img = img;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(real);
        sb.append("+");
        sb.append(img);
        sb.append("i");
        return sb.toString();
    }
}