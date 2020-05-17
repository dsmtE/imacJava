package fr.umlv.arthur;

public class Bow extends Equipment implements Weapon, Protective {
    private final int damage;
    private final int protection;

    public Bow(final String n, final int d, final int p) throws IllegalArgumentException{
        super(n);
        if (d <= 0) { throw new IllegalArgumentException("les dommages ne peuvent pas être négatifs"); }
        if (p <= 0) { throw new IllegalArgumentException("la protection ne peut pas nulle ou négative"); }
        protection = p;
        damage = d;
    }

    public Bow(final String n) {
        this(n, 1, 1);
    }

    // getters
    @Override
    public final int damage() { return damage; }

    @Override
    public final int protection() { return protection; }

    // @Override
    // public String toString() {
    //     return name() + "(d:" + damage + ", p:" + damage + ")";
    // }

    @Override
    public String toString() {
        return name();
    }

    @Override
	public boolean equals(final Object o) {
        if (o == null) { return false; } 
        if (o == this) { return true; }
        if (!(o instanceof Bow)) { return false; }
        final Bow s = (Bow) o;

        return super.equals(s) && damage == s.damage && protection == s.protection;
    }
}