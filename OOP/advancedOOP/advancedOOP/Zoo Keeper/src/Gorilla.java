
public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("-------------------");
		energyLevel=energyLevel-5;
		System.out.println(" the gorilla has decrease 5");
		
	}
	public void eatBananas() {
		System.out.println("-------------------");

		energyLevel=energyLevel+10;
		System.out.println(" the gorilla has increase by 10");
		System.out.println(energyLevel);


		
		}
	public void climb() {
		System.out.println("-------------------");
		energyLevel=energyLevel-10;
		System.out.println(" the gorilla has decrease by 10");
		System.out.println(energyLevel);
	}

}
