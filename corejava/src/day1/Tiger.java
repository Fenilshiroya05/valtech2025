package day1;

public class Tiger implements Animal {

	@Override
	public void makeSound() {
		System.out.println("Roar.....");
	}

	@Override
	public void eat() {
		System.out.println("Eat deer.....");
	}

	@Override
	public void sleep() {
		System.out.println("Loudly......");
	}

}
