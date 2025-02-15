package io.github.fdero.miniregex;

public final class CharRegex extends Regex {

    private final char character;

    public CharRegex(char character) {
        this.character = character;
    }

    @Override
    protected Nullability getNullability() {
        return Nullability.NON_NULLABLE;
    }

    @Override
    protected Regex derive(char character) {
        return (this.character == character)
            ? SpecialRegex.EPS 
            : SpecialRegex.FAILURE;
    }
}
