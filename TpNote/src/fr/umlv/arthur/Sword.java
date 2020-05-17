package fr.umlv.arthur;

// ----- 01 ----- //
public class Sword extends Equipment implements Weapon {
    private final int damage;

    public Sword(final String n, final int d) throws IllegalArgumentException{
        super(n);
        if (d <= 0) { throw new IllegalArgumentException("les dommages ne peuvent pas être négatifs"); }
        damage = d;
    }

    public Sword(final String n) {
        this(n, 1);
    }

    @Override
    public final int damage() { return damage; }

    // @Override
    // public String toString() {
    //     return name() + "(" + damage + ")";
    // }

    @Override
    public String toString() {
        return name();
    }

    @Override
	public boolean equals(final Object o) {
        if (o == null) { return false; } 
        if (o == this) { return true; }
        if (!(o instanceof Sword)) { return false; }
        final Sword s = (Sword) o;

        return super.equals(s) && damage == s.damage;
    }
}