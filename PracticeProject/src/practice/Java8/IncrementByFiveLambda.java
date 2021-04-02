package practice.Java8;

public class IncrementByFiveLambda {

    public static void main(String[] args) {

        IncrementByFive incrementByFive = (a) -> a + 5;
        System.out.println(incrementByFive.increment(10));
    }
}
