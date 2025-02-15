package io.github.fdero.miniregex;

public final class CharRegex extends Regex {

    private final char character;

    public CharRegex(char character) {
        this.character = character;
    }

    @Override
    protected Regex delta() {
        return EmptyRegex.FAILURE;
    }

    @Override
    protected Regex derive(char character) {
        return (this.character == character)
            ? EmptyRegex.EPS 
            : EmptyRegex.FAILURE;
    }
}
