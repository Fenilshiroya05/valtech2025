package Day2;

public class SimpleArithmetic implements Arithmetic {
	
	
	@Override
	public double add(double a, double b) {
		return a+b;
	}

	@Override
	public double sub(double a, double b) {
		return a-b;
	}

	@Override
	public double mul(double a, double b) {
		return a*b;
	}

	@Override
	public double div(double a, double b) {
		return a/b;
	}
	
	public static void main(String[] args) {
		SimpleArithmetic number=new SimpleArithmetic();
		System.out.println(number.add(10,20));
		System.out.println(number.sub(20, 10));
		System.out.println(number.div(4, 2));
		System.out.println(number.mul(3, 2));
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}

}
