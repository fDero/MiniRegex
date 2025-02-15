package io.github.fdero.miniregex;

public final class UnionRegex extends Regex {

    private final Regex lxRegex;
    private final Regex rxRegex;

    public UnionRegex(Regex lxRegex, Regex rxRegex) {
        this.lxRegex = lxRegex;
        this.rxRegex = rxRegex;
    }

    @Override
    protected Nullability getNullability() {
        switch (lxRegex.compareNullability(rxRegex)) {
            case BOTH_NON_NULLABLE: return Nullability.NON_NULLABLE;
            case BOTH_NULLABLE: return Nullability.NULLABLE;
            default: return Nullability.NULLABLE;
        }
    }

    @Override
    protected Regex derive(char character) {
        return new UnionRegex(
            lxRegex.derive(character), 
            rxRegex.derive(character)
        );
    }
}
