package structural.flywayPattern.object;

public class Particle {

    private final ParticleType type; // reference to flyweight
    private final float x;
    private float y;
    private final float velocity;

    public Particle(ParticleType type, float x, float y, float velocity) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public void update() {
        y += velocity;
        type.render(x, y, velocity);
    }
}
