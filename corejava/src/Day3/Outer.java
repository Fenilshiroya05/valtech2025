package Day3;

public class Outer {
	
	private int a;
	
	public void outerPrint() {
		System.out.println("Outer print..");
	}
	
	public static class StaticInner{
		public void print(Outer o) {
			System.out.println(" static a ="+ o.a);
		}
	}
	
	private static abstract class Just{
		abstract void print();
	}
	
	public static class JustImpl extends Just{
		@Override
		void print() {
			System.out.println("My Job is to Just print...");
		}
	}
	
	public class Inner{
		
		private int b;
		
		public void print() {
			System.out.println("Inner print a = " +a +" b = "+ b);
		}
		
		public void addOne() {
			a++;
			b++;
		}
		
		public class InnerInner{
			
		}
	}
	
	public static void main(String[] args) {
		Outer o=new Outer();
		Outer.Inner i= o.new Inner();
		i.addOne();
		Outer.Inner i2 =o.new Inner();
		i2.print();
		i.print();
		
		Outer o1=new Outer();
		Outer.Inner i3=o1.new Inner();
		i3.addOne();
		i3.print();
		i.print();
		
		StaticInner si = new StaticInner();
		si.print(o1);
		
		Just j = new JustImpl();
		j.print();
		
		Just j1 = new Just() {
			@Override
			void print() {
				System.out.println("Just ANONYMOUS.....");
			};
		};
		j1.print();
	}

}
