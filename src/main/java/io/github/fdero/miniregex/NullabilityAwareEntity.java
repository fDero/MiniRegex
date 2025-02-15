package io.github.fdero.miniregex;

abstract class NullabilityAwareEntity {
    
    protected static enum Comparison {
        BOTH_NON_NULLABLE,
        BOTH_NULLABLE,
        DIFFERENT;
    }

    protected static enum Nullability {
        NON_NULLABLE,
        NULLABLE;
    }

    protected abstract Nullability getNullability();

    Comparison compareNullability(Regex other) {
        
        Nullability otherNullability = other.getNullability();
        Nullability thisNullability = this.getNullability();
        
        switch (thisNullability) {
            case NON_NULLABLE: 
                return (thisNullability == otherNullability)
                ? Comparison.BOTH_NON_NULLABLE 
                : Comparison.DIFFERENT; 
            default: 
                return (thisNullability == otherNullability)
                ? Comparison.BOTH_NULLABLE 
                : Comparison.DIFFERENT;
        }
    }
}
