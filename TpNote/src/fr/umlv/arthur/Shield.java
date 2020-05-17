package fr.umlv.arthur;

public class Shield extends Equipment implements Protective {
    private final int protection;

    public Shield(final String n, final int p) throws IllegalArgumentException {
        super(n);
        if (p <= 0) { throw new IllegalArgumentException("la protection ne peut pas nulle ou négative"); }
        protection = p;
    }

    public Shield(final String n) {
        this(n, 1);
    }

    // getters
    @Override
    public final int protection() { return protection; }

    // @Override
    // public String toString() {
    //     return name() + "(" + protection + ")";
    // }

    @Override
    public String toString() {
        return name();
    }

    @Override
	public boolean equals(final Object o) {
        if (o == null) { return false; } 
        if (o == this) { return true; }
        if (!(o instanceof Shield)) { return false; }
        final Shield s = (Shield) o;

        return super.equals(s) && protection == s.protection;
    }
}