package io.github.fdero.miniregex;

public final class ConcatRegex extends Regex {

    private final Regex lxRegex;
    private final Regex rxRegex;

    public ConcatRegex(Regex lxRegex, Regex rxRegex) {
        this.lxRegex = lxRegex;
        this.rxRegex = rxRegex;
    }

    @Override
    protected Nullability getNullability() {
        switch (lxRegex.compareNullability(rxRegex)) {
            case BOTH_NON_NULLABLE: return Nullability.NON_NULLABLE;
            case BOTH_NULLABLE: return Nullability.NULLABLE;
            default: return Nullability.NON_NULLABLE;
        }
    }

    @Override
    protected Regex derive(char character) {
        
        Regex tryDeriveLeft = new ConcatRegex(lxRegex.derive(character), rxRegex);
        
        return (lxRegex.getNullability() == Nullability.NON_NULLABLE)
            ? tryDeriveLeft
            : new UnionRegex(tryDeriveLeft, rxRegex.derive(character));
    }
}
