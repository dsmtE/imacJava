package fr.umlv.geom;

//-----01----- //
// l'heritage permet de reutiliser les attributs et methodes de la classe dont 
// on hérite tout en spécifiant un comportement spécifique si necessaire ( evite la redondance)
public class Ring extends Circle {
	
	private int internalRadius;
	
	//-----03----- //
	public Ring(final Point c, final int r, final int iR) throws IllegalArgumentException {
		super(c, r);
		// l'idée est d'utilier une exception pour verifier les arguments
		if( iR < r) {
			throw new IllegalArgumentException("le rayon interne doit être plus petit que le rayon");
		}
		internalRadius = iR;
	}
	
	public int internalRadius() {
		return internalRadius;
	}
	
	@Override
	public String toString() {
		return super.toString() + "InternalRadius:" + internalRadius;
	}
	
	public static void main(String[] args) {
		Point point = new Point(1, 2);
	    Circle circle = new Circle(point, 2);
	    System.out.println(circle);
	    Ring ring;
	    try {
	    	ring = new Ring(point, 2, 1);
	    	System.out.println(ring);
	    } catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	    
	}
	
	@Override
	public boolean contains(final Point p) {
		final Circle internalCircle = new Circle(center(), internalRadius);
		return super.contains(p) && !internalCircle.contains(p);
	}
	
	public static boolean contains(final Point p, final Ring... rings) {
		return Circle.contains(p, rings);
	}
}
