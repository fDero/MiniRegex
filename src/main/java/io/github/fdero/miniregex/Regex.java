package io.github.fdero.miniregex;

public abstract class Regex extends NullabilityAwareEntity {
    
    protected abstract Regex derive(char character);
    
    public final boolean matches(String text) {
        Regex partiallyDerived = this;
        for (char character : text.toCharArray()) {
            partiallyDerived = partiallyDerived.derive(character);
        }
        return partiallyDerived.getNullability() == Nullability.NULLABLE;
    }
}
