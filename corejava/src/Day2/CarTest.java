package Day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	@Test
	void testClone() throws Exception {
		Car car=new Car("Honda","City","VX",2018,7);
		Car car1= (Car)car.clone();
		assertEquals(car,car1); //check contents if equals is override
		assertNotSame(car,car1);//only check reference but contents are same
	}
	
	@Test
	void testHashcode() {
		
		Car car=new Car("Honda","City","VX",2018,7);
		int hash=car.hashCode();
		System.out.println(car+" "+car.hashCode());
		assertEquals(hash, car.hashCode());
		
		assertEquals(hash, new Car("Honda","City","VX",2018,7).hashCode());
		
		car.setVariant("ZX");
		System.out.println(car+" "+car.hashCode());
		assertNotEquals(hash,car.hashCode());
		
		car.setModel("Jazz");
		System.out.println(car+" "+car.hashCode());
		assertNotEquals(hash,car.hashCode());
		
		car.setVersion(8);
		System.out.println(car+" "+car.hashCode());
		assertNotEquals(hash,car.hashCode());
		
		car.setYear(2020);
		System.out.println(car+" "+car.hashCode());
		assertNotEquals(hash,car.hashCode());
	}

	@Test
	void testToString() {
		
		Car car=new Car("Honda","City","VX",2018,7);
		assertEquals("Honda City VX 2018 Version 7", car.toString());
		car.setVariant("ZX");
		assertEquals("Honda City ZX 2018 Version 7",car.toString());
		car.setModel("Jazz");
		assertEquals("Honda Jazz ZX 2018 Version 7",car.toString());
		car.setVersion(8);
		assertEquals("Honda Jazz ZX 2018 Version 8",car.toString());
		car.setYear(2020);
		assertEquals("Honda Jazz ZX 2020 Version 8",car.toString());
	}

}
