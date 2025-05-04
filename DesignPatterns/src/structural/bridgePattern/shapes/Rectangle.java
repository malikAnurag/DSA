package structural.bridgePattern.shapes;

import structural.bridgePattern.renderer.Renderer;

public class Rectangle extends Shape {

    private final double width;
    private final double height;

    public Rectangle(Renderer renderer, double width, double height) {
        super(renderer);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        renderer.renderRectangle(width, height);
    }
}
