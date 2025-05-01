package creationalDesignPatterns.prototype;


/*
 * To create something and not starting from scratch
 * Clone an existing thing and make a few small changes
 * This pattern allows you to create a new object by cloning an existing prototype and modifying only what's needed
 *
 * Application : Video game characters
 *
 * Benefits :   Efficiency & code optimization
 *              Leads to no duplication of code
 *              Modify ONLY that is necessary
 *              Saves time and effort
 *
 * Earlier every character was starting from scratch
 * */

public class Character implements Cloneable {

    private String name;
    private int health;
    private int attackPower;
    private int level;

    public Character(String name, int health, int attackPower, int level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.level = level;
    }

    @Override
    public Character clone() throws CloneNotSupportedException {
        // shallow copy of the character object
        // shallow copy : use same reference of the object (which are present inside the object being copied) and doesn't create a new object
        return (Character) super.clone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
