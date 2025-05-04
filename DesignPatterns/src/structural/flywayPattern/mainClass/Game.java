package structural.flywayPattern.mainClass;

import structural.flywayPattern.factory.ParticleTypeFactory;
import structural.flywayPattern.object.Particle;
import structural.flywayPattern.object.ParticleType;

import java.util.ArrayList;
import java.util.List;


// In this implementation, we've achieved significant memory savings.
// Instead of storing color and sprite data for each of the 1000 particles (which would require 1000 copies),
// we store this data just once in the ParticleType flyweight and share it across all particles.
//
// Each particle only needs to store its own position and velocity, plus a reference to the shared ParticleType.

// Advantages : Memory Efficiency, Performance, Scalability, Maintenance
// Real life use cases : Text editors, Game development, Web browsers, Graphics Applications
public class Game {

    public static void main(String[] args) {

        ParticleTypeFactory factory = new ParticleTypeFactory();
        List<Particle> particles = new ArrayList<>();

        // Create thousands of particles using shared flyweights
        ParticleType explosionType = factory.getParticleType("red", "explosion.png");

        for (int i = 0; i < 1000; i++) {
            particles.add(new Particle(explosionType,
                    (float) Math.random() * 100,
                    (float) Math.random() * 100,
                    1.0f));
        }
        // Update all particles
        for (Particle particle : particles) {
            particle.update();
        }
    }
}
