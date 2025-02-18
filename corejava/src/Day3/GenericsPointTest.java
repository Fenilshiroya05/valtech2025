package Day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenericsPointTest {

	
	@Test
	void testString() {
		GenericsPoint<String> p =new GenericsPoint<>();
		p.setX("AB");
		p.setY("CD");
		System.out.println(p);
	}
	
	@Test
	void testInt() {
		GenericsPoint<Integer> p =new GenericsPoint<>();
		p.setX(3);
		p.setY(4);
		System.out.println(p);
	}
	
	@Test
	void testDouble() {
		GenericsPoint<Double> p =new GenericsPoint<>();
		p.setX(3D);
		p.setY(4D);
		System.out.println(p);
	}

}
