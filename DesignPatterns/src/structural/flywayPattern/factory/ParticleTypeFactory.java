package structural.flywayPattern.factory;

import structural.flywayPattern.object.ParticleType;

import java.util.HashMap;
import java.util.Map;


public class ParticleTypeFactory {

    private final Map<String, ParticleType> particleTypes = new HashMap<>();

    public ParticleType getParticleType(String color, String sprite) {
        String key = color + "_" + sprite;
        return particleTypes.computeIfAbsent(key, k -> new ParticleType(color, sprite));
    }
}
