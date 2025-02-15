package io.github.fdero.miniregex;

public final class StarRegex extends Regex {
    
    private final Regex repeatedRegex;
    
    public StarRegex(Regex repeatedRegex) {
        this.repeatedRegex = repeatedRegex;
    }

    @Override
    protected Regex delta() {
        return EmptyRegex.EPS;
    }

    @Override
    protected Regex derive(char character) {
        return new ConcatRegex(
            repeatedRegex.derive(character), 
            this
        );
    }
}
