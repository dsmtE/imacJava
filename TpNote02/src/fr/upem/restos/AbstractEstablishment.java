package fr.upem.restos;

import java.util.Objects;

abstract class AbstractEstablishment implements Establishment {

    private final String name;
    private final int stars;

    public AbstractEstablishment(final String n, final int s) throws IllegalArgumentException {
        if (s < 0) {
            throw new IllegalArgumentException("AbstractEstablishment: stars can't be negative !");
        }
        name = Objects.requireNonNull(n);
        stars = s;
    }

    public AbstractEstablishment(final String n) {
        this(n, DEFAULT_STARS);
    }

    @Override
    public String toString() {

        return name + "*".repeat(stars);
        /*
         * or StringBuilder str = new StringBuilder(name); 
         * for (int i = 0; i < stars; i++) { str.append("*"); } return str.toString();
         */

    }

    @Override
    public boolean equals(final Object o) {

        if (o == null) { return false; }
        if (o == this) { return true; }
        if (!(o instanceof AbstractEstablishment)) { return false; }
        final AbstractEstablishment r = (AbstractEstablishment) o;
        return name.equals(r.name) && stars == r.stars;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + name().hashCode();
        hash = 31 * hash + stars();
        return hash;
    }

    @Override
    final public String name() { return name; }
    @Override
    final public int stars() { return stars; }

}