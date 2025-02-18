package day1;

public class Cat implements Animal {

	@Override
	public void makeSound() {
		System.out.println("mewoo.....");

	}

	@Override
	public void eat() {
		System.out.println("Eating rat.....");

	}

	@Override
	public void sleep() {
		System.out.println("Soundly zzzzzzzzz.......");

	}

}
