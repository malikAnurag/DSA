package structural.bridgePattern.shapes;

import structural.bridgePattern.renderer.Renderer;

// Circle.java - Refined abstraction for Circle
public class Circle extends Shape {

    private final double radius;

    public Circle(Renderer renderer, double radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }
}