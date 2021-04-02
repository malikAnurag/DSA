package practice;

/**
 * Checking compiler behavior in case of method over riding along with polymorphism!!
 */
public class PolyMorphismTest {

    public static void main(String[] args) {

        //Reference of Animal having Dog's object
        Animal1 a = new Dog1();

        //During compile time, the compiler only checks the class of reference type for the called method
        System.out.println(a.printString());
    }
}


class Animal1 {

    //Comment this method and check the error
    public String printString() {
        System.out.println("Method call from Animal");
        return null;
    }
}


class Dog1 extends Animal1 {
    public String printString(){
        System.out.println("Method call from Dog!!");
        return null;
    }

    public String foo() {
        return "FOOOOOO";
    }
}