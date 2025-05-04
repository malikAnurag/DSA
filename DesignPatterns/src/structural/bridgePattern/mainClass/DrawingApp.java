package structural.bridgePattern.mainClass;

import structural.bridgePattern.renderer.RasterRenderer;
import structural.bridgePattern.renderer.Renderer;
import structural.bridgePattern.renderer.VectorRenderer;
import structural.bridgePattern.shapes.Circle;
import structural.bridgePattern.shapes.Rectangle;
import structural.bridgePattern.shapes.Shape;


// The Bridge Design Pattern is a powerful tool for decoupling abstraction from implementation.
// In our drawing application example, it allows shapes and rendering methods to evolve independently,
// making the system flexible, scalable, and maintainable.
// Whether you’re designing a graphics library, a UI framework, or any system with varying abstractions and
// implementations, the Bridge Pattern is an excellent choice for clean architecture and long-term growth.
public class DrawingApp {

    public static void main(String[] args) {

        Renderer rasterRenderer = new RasterRenderer();
        Renderer vectorRenderer = new VectorRenderer();

        Shape rasterCircle = new Circle(rasterRenderer, 5);
        Shape vectorCircle = new Circle(vectorRenderer, 5);

        Shape rasterRectangle = new Rectangle(rasterRenderer, 10, 5);
        Shape vectorRectangle = new Rectangle(vectorRenderer, 10, 5);

        rasterCircle.draw();
        vectorCircle.draw();
        rasterRectangle.draw();
        vectorRectangle.draw();
    }
}
