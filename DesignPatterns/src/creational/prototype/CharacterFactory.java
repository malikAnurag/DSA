package creational.prototype;

public class CharacterFactory {

    private final Character prototypeCharacter;

    public CharacterFactory() {
        prototypeCharacter = new Character("Name", 100, 50, 1);
    }

    public Character createCharacterWithNewName(String name) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter.setName(name);
        return clonedCharacter;
    }

    public Character createCharacterWithNewLevel(int level) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter.setLevel(level);
        return clonedCharacter;
    }

}
