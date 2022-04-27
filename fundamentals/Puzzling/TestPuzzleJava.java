package fundamentals.Puzzling;

import java.util.ArrayList;

public class TestPuzzleJava {
    public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		int[] randomRolls = generator.getTenRolls();
        for(int i=0; i<randomRolls.length;i++){
            System.out.println(randomRolls[i]);
        }
		System.out.println("--------------------------------");
        char a=generator.getRandomLetter();
        System.out.println(a);
        String password=generator.generatePassword();
        System.out.println(password);
        ArrayList<String> passwords= new ArrayList<String>();
        passwords=generator.getNewPasswordSet(5);
        System.out.println(passwords);


	}
    
}
