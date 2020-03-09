package fr.umlv.geom;

import java.util.Arrays;

public class Circle {
	
	// -----02----- //
	// on doit les déclarer private
	private int radius;
	private Point center;
	
	// -----03----- //
	public Circle(final Point c, final int r) {
		radius = r;
		// -----06----- //
		// pour eviter que la translation affect plusieurs cercle il faut 
		// recopier le point et pas uniquement sa référence ( adresse)
		center = new Point(c.getX(), c.getY());
	}
	public Circle(final Point center) {
		this(center, 1);
	}
	// public Circle() {
	// 	this( Circle( new Point(0,0)));
	// }
	
	public int radius() {
		return radius;
	}
	
	// -----07----- //
	// cette méthode retourne une référnce et donc le point pourra être
	// modifié à l'extérieur de la classe et ça peut etre un probleme
	// public Point center() {
	//		return center;
	//	}
	public Point center() {
		return new Point(center.getX(), center.getY());
	}
	// ici on retourne bien une copie 
	
	// -----05----- //
	public void translate(final int dx, final int dy) {
		center.translate(dx, dy);
	}
	
	// -----04----- //
	@Override
	public String toString() {
		return "(" + center + ',' + radius + ')';
	}
	
	public static void main(String[] args) {
		Point point = new Point(1, 2);
		Circle circle = new Circle(point, 1);

		Circle circle2 = new Circle(point, 2);
		circle2.translate(1, 1);

		System.out.println(circle + " " + circle2);
	}
	
	// -----08----- //
	public double surface() {
		return Math.PI*Math.pow(radius, 2);
	}
	
	// -----09----- //
	public boolean contains(final Point p) {
		return (Math.pow(center.getX()-p.getX(), 2) + Math.pow(center.getY()-p.getY(), 2))  <= radius*radius;
	}
	
	// -----10----- //
	// on utilise ici le spread operator
	// public static boolean contains(final Point p, final Circle... circles) {
	// 	return circles[0].contains(p) || Circle.contains(p, Arrays.asList(circles).subList(1, circles.length).toArray(new Circle[0]));	
	// }
	public static boolean contains(final Point p, final Circle... circles) {
		boolean result = false;
		for(final Circle c : circles) {
			result = result || c.contains(p);
			if(result) {
				break;
			}
		}
		return result;
	}
	
}
