package fr.umlv.geom;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + ',' + y + ')';
	}
	
	// -----01----- //
	// ne compile pas car on essaye de modifier un attribut final
	public void translate(int dx, int dy) {
	  x += dx;
	  y += dy;
	}
	
}