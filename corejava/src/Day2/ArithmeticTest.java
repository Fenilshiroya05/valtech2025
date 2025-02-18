package Day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmeticTest {
	
	private Arithmetic arith =new SimpleArithmetic();

	@Test
	void testAdd() {
		assertEquals(5,arith.add(2.3, 2.7),0.0);
	}
	@Test
	void testSub() {
		assertEquals(2,arith.sub(2.0, 1.0),0.0);
	}
	@Test
	void testMul() {
		assertEquals(6,arith.mul(3.0, 2.0),0.0);
	}
	
	@Test
	void testDivWithDInt() {
		assertEquals(2, arith.div(4,2));
		assertEquals(3, arith.div(7, 2));
	}
	@Test
	void testDivWithDouble() {
		assertEquals(1.666, arith.div(5.,3),0.001);
		assertEquals(Double.POSITIVE_INFINITY, arith.div(5., 0),0.0001);
	}
	@Test
	void testDivWithIntDenomIsZero() {
		try {
			arith.div(3, 0);
			
		} catch (Exception e) {
			System.out.println("Exception was expected..");
		}
	
	}
	
	

		
}
