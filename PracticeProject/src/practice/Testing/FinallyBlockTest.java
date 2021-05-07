package practice.Testing;

public class FinallyBlockTest {

    public static void main(String[] args) {

        System.out.println(foo());
    }


    public static int foo() {
        try {
            throw new Exception();
//            return 1;
        }
        catch (Exception e) {
            return 5;
        }
        finally {
            return 2;
        }
    }

}
