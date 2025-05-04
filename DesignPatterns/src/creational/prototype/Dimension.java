package creational.prototype;

public class Dimension implements Cloneable {

    int height;
    int weight;

    public Dimension(int h, int w) {
        this.height = h;
        this.weight = w;
    }

    @Override
    public Dimension clone() throws CloneNotSupportedException {
        return (Dimension) super.clone();
    }
}
