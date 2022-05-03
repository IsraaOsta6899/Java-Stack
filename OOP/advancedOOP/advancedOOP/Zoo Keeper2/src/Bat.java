
public class Bat extends Mammal{
	public Bat() {
		super.energyLevel=300;
		}
	public void fly() {
		energyLevel =energyLevel-50;
		System.out.println(" the sound of a bat taking off and decrease its energy by 50.");
		System.out.println(energyLevel);
		System.out.println("-----------------------------");
	}
	public void eatHumans() {
		energyLevel =energyLevel+25;
		System.out.println("the so- well, never mind, just increase its energy by 25.");
		System.out.println(energyLevel);
		System.out.println("-----------------------------");
		}
	public void attackTown() {
		energyLevel =energyLevel-100;
		System.out.println(" the sound of a town on fire and decrease its energy by 100.");
		System.out.println(energyLevel);
		System.out.println("-----------------------------");
	}

//fly(), eatHumans(), and attackTown() a
	}
