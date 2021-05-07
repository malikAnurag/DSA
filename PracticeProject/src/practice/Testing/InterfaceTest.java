package practice.Testing;

interface Aa {
    void show();
}

interface Bb {
    void show();
}

class InterfaceT implements Aa, Bb {
    public void show() {
        System.out.println("Show");
    }
}


public class InterfaceTest {
    public static void main(String[] args) {
        Bb i1 = new InterfaceT();
        i1.show();
    }
}