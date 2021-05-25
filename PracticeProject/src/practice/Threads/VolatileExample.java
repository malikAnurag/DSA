package practice.Threads;

public class VolatileExample {

    public static volatile boolean flag = false;

    public static void main(String[] args) {

        new Thread(() -> {

            for(int i = 0 ; i < 200 ; i++)
                System.out.println("Value of i is :" + i);

            flag = true;

            System.out.println("Value of flag is : " + flag);

        }).start();

        new Thread(() -> {
            int i = 1;
            while(!flag) {
                i++;
            }
            System.out.println("Value of i in second thread is : " + i);
        }).start();
    }
}
