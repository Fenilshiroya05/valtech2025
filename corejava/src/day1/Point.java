package day1;

public class Point {
	
	public static double ORIGIN= 0;
	private double x;
	private double y;
	
	public Point() {} // default constructor
	
	public Point(final double x, final double y) { //parameterized constructor
		this.x=x;// it refers to current object or variable of this class only
		this.y=y;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double distance() { // starting point
		return distance(0,0);
	}
	
	//public abstract void markMeOnScreen(); //not allowed to make instance of this class , but for subclass allowed 
	
	/*public double distance() {
		return Math.sqrt(x*x + y*y);
	}*/
	
	public double distance(final double x1, final double y1) {
		double diffx=x1-x;
		double diffy=y1-y;
		return Math.sqrt(diffx * diffx + diffy * diffy);
	}
	
	public double distance(Point p) {
		return distance(p.x, p.y);
	}

	public static void main(String[] args) {
		Point p= new Point(10,30);
		System.out.println(p);
		System.out.println(p.distance());
		System.out.println(p.distance(100,200));
		System.out.println(p.distance(p));
	}
	
	@Override
	public String toString() {
			return new StringBuilder().append("Point x=")
					.append(x)
					.append(" y=")
					.append(y).toString();
	}
}
