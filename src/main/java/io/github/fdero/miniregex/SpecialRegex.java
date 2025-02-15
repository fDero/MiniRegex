package io.github.fdero.miniregex;

final class SpecialRegex extends Regex {
    
    public static final SpecialRegex EPS = new SpecialRegex();
    public static final SpecialRegex FAILURE = new SpecialRegex();

    private SpecialRegex() {}

    @Override
    protected Nullability getNullability() {
        return (this == EPS)
            ? Nullability.NULLABLE
            : Nullability.NON_NULLABLE;
    }

    @Override
    protected Regex derive(char character) {
        return FAILURE;
    }
}
