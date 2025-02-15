package io.github.fdero.miniregex;

public final class UnionRegex extends Regex {

    private final Regex lxRegex;
    private final Regex rxRegex;

    public UnionRegex(Regex lxRegex, Regex rxRegex) {
        this.lxRegex = lxRegex;
        this.rxRegex = rxRegex;
    }

    @Override
    protected Regex delta() {
        Regex lxDelta = lxRegex.delta();
        Regex rxDelta = rxRegex.delta();

        boolean lxEPS = lxDelta == EmptyRegex.EPS;
        boolean rxEPS = rxDelta == EmptyRegex.EPS;
        boolean lxFAILURE = lxDelta == EmptyRegex.FAILURE;
        boolean rxFAILURE = lxDelta == EmptyRegex.FAILURE;
        
        if (lxEPS || rxEPS) return EmptyRegex.EPS;
        if (lxFAILURE && rxFAILURE) return EmptyRegex.FAILURE;
        return new UnionRegex(lxDelta, rxDelta);
    }

    @Override
    protected Regex derive(char character) {
        return new UnionRegex(
            lxRegex.derive(character), 
            rxRegex.derive(character)
        );
    }
}
