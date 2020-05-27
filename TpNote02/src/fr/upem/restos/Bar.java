package fr.upem.restos;

public class Bar extends AbstractEstablishment {
    private final boolean openAfterEight;

    public Bar(final String n, final boolean  o, final int s) throws IllegalArgumentException {
        super(n, s);
        openAfterEight = o;
    }

    public Bar(final String n, final Boolean o) throws IllegalArgumentException {
        this(n, o, DEFAULT_STARS);
    }

    @Override
    public String toString() {
        return super.toString() + " (" + (openAfterEight ? "" : "not " ) + "open after eight)";
    }

    @Override
    public boolean equals(final Object o) {

        if (! super.equals(o)) { return false; }
        if (!(o instanceof Bar)) { return false; }
        final Bar r = (Bar) o;
        return openAfterEight == r.openAfterEight;
    }

    @Override
    public int hashCode() {
        return  31 * super.hashCode() + (openAfterEight ? 1 : 0);
    }

    // final public boolean openAfterEight() { return openAfterEight; }
    
}