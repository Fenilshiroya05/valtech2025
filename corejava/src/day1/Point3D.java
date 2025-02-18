package day1;

public abstract class Point3D extends Point {
	
	private double z;
	
	public double getZ() {
		return z;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	

	public Point3D() { //default constructor
		this(0,0,0);
	}
	
	public Point3D(double x, double y, double z) { // parameterized constructor
		super(x,y);//parent class constructor
		this.z=z;
	}
	
	public double distance(Point3D p) {
		return distance(p.getX(),p.getY(),p.getZ());
	}
	
	public double distance(double x, double y, double z) { //override distance method
		double diffx= getX()-x;
		double diffy=getY()-y;
		double diffz=getZ()-z;
		return Math.sqrt(diffx*diffx + diffy*diffy + diffz*diffz);
	}
	
	@Override
	public double distance() {
		return Math.sqrt(getX()*getX() + getY()*getY() + z*z);
	}
  
}
