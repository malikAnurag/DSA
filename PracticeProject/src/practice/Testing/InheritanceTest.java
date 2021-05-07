package practice.Testing;

public class InheritanceTest {

    public static void main(String[] args) {

        Animal a = new Dog();
        System.out.println(a.toString1());
//        Animal a = new Animal();
//        Dog d = a;        // Doesnt work
    }
}


class Animal {
    int age;

//    Animal(int age) {
//        super();  //Optional
//        this.age = age;
//    }

    public String toString1() {
        System.out.println("to String from Animal");
        return null;
    }
}


class Dog extends Animal {

//    Dog() {
//        super();
//    }


    public String toString1(){

        System.out.println("to String from Dog!!");
        return null;
    }
}