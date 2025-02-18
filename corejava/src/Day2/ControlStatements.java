package Day2;

public class ControlStatements {
	
	public void testIfElse(int a) {
		if(a%2==0) {
			System.out.println(a+" is Even.");
		}else
		{
			System.out.println(a+" is Odd.");
		}
	}
	
	public void testFor(int a[] ){
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void testSwitch(int a) {
		switch(a) {
		case 1: 
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
		case 3:
			System.out.println("Three");
			break;
		default:
			System.out.println("All Others..");
		}
	}
	
	public int add(int ... a) { //variable arguments ( var args)
		int sum =0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		System.out.println("sum= "+sum);
		return sum;
	}
	
//	public int add(String msg,int iv,int ... a) { //variable arguments (var args)
//		int sum =iv;
//		for (int i = 0; i < a.length; i++) {
//			sum+=a[i];
//		}
//		System.out.println(msg+ "sum = "+sum);
//		return sum;
//	}
	
	public static void main(String[] args) {
		ControlStatements cs=new ControlStatements();
		cs.testIfElse(0);
		cs.testIfElse(3);
		cs.testIfElse(4);
		cs.testFor(new int [] {1,2,3});
		cs.testFor(new int [] {3,4,5,6,7});
		cs.testSwitch(1);
		cs.testSwitch(2);
		cs.testSwitch(3);
		cs.testSwitch(43);
		
		cs.add(1,2,2);
		cs.add(1,3,4,6);
		
		//cs.add("sum of [1,2,3]",1,2,3); 
		
		
		
	}
  
}
