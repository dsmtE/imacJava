package fr.upem.restos;

public class Resto extends AbstractEstablishment {
    private final int covers;

    public Resto(final String n, final int  c, final int s) throws IllegalArgumentException {
        super(n, s);
        if (c <= 0) {
            throw new IllegalArgumentException("Resto constructor: covers can't be negative or null !");
        }
        covers = c;
    }

    public Resto(final String n, final int c) throws IllegalArgumentException {
        this(n, c, DEFAULT_STARS);
    }

    @Override
    public String toString() {
        return super.toString() + " (covers: " + covers + ")";
    }

    @Override
    public boolean equals(final Object o) {

        if (! super.equals(o)) { return false; }
        if (!(o instanceof Resto)) { return false; }
        final Resto r = (Resto) o;
        return covers == r.covers;
    }

    @Override
    public int hashCode() {
        return  31 * super.hashCode() + covers;
    }

    final public int covers() { return covers; }

}