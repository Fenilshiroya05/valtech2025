package day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalTest {

	// annotation= metadata
	@Test                             			
	void testDog() {
		Dog dog=new Dog();
		System.out.println();
		showBehaviour(dog);
		//fail("Should fail..");
	}

	@Test
	void testCat() {
		System.out.println();
		showBehaviour(new Cat()); // directly assigned because no need in future
	}

	@Test
	void testTiger() {
		System.out.println();
		showBehaviour(new Tiger());
	}
	
	private void showBehaviour(Animal a) {
		a.makeSound();
		a.eat();
		a.sleep();
	}

}
