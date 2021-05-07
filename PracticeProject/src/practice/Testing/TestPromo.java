package practice.Testing;

public class TestPromo {
    public static void main(String[] args) {
        Dog2 dg = new Dog2();
        dg.setName("Leo");
        AnimalUtil animalUtil = new AnimalUtil();
        animalUtil.printName(dg);
    }
}



abstract class Animal2 {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Dog2 extends Animal2 {}


class AnimalUtil {
    void printName(Animal2 animal) {
        System.out.println(animal.getName());
    }
}