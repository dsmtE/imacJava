// ----- 02.03 ----- //
public class Pear implements Fruit {
	private final int juiceFactor;

	public Pear(int jf) throws IllegalArgumentException {
        if( jf < 0 || jf > 9 ) { throw new IllegalArgumentException("le JuiceFactor est invalide (must be in [0, 9])"); }
		juiceFactor = jf;
	}

	@Override
	public int price() { return juiceFactor * 3; }

	@Override
	public String toString() {
		return "Pear(juiceFactor: " + juiceFactor + ")";
	}
	
	@Override
	public boolean equals(final Object o) {

        if (o == null) { return false; }
        if (o == this) { return true; }
        if (!(o instanceof Pear)) { return false; }
        final Pear p = (Pear) o;

        return juiceFactor == p.juiceFactor;
	}
	
	@Override
    public int hashCode() {
        return 31 * 7 + juiceFactor;
    }
}