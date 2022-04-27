package fundamentals.Puzzling;
import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava{
    public int[] getTenRolls(){
        int []arr= new int[10];
        Random randMachine = new Random();
        for(int i=0 ; i<10;i++){
            int num=randMachine.nextInt(20 - 1) + 1;
            arr[i]=num;
        }
        return arr;
    }
    public char getRandomLetter(){
        Random randMachine = new Random();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int num=randMachine.nextInt(26 - 1) + 1;
        return alphabet[num];

    }
    public String generatePassword(){
        String password="";
        for(int i=0 ; i< 8;i++){
            password+=getRandomLetter();
        }
        return password;
    }
    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> passwords= new ArrayList<String>();
        for(int i=0 ; i<length;i++){
            passwords.add(generatePassword());
        }
        return passwords;
    }


}