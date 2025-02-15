package io.github.fdero.miniregex;

final class EmptyRegex extends Regex {
    
    public static final EmptyRegex EPS = new EmptyRegex();
    public static final EmptyRegex FAILURE = new EmptyRegex();

    private EmptyRegex() {}

    @Override
    protected Regex derive(char character) {
        return FAILURE;
    }

    @Override
    protected Regex delta() {
        return this;
    }
}
