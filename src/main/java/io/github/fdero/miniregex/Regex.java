package io.github.fdero.miniregex;

public abstract class Regex {
    
    protected abstract Regex derive(char character);
    protected abstract Regex delta();

    public final boolean matches(String text) {
        Regex partiallyDerived = this;
        for (char character : text.toCharArray()) {
            partiallyDerived = partiallyDerived.derive(character);
        }
        return partiallyDerived.delta() == EmptyRegex.EPS;
    }
}
