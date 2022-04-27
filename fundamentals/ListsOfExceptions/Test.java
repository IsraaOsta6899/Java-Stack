package fundamentals.ListsOfExceptions;

import java.util.ArrayList;

public class Test {
    public static void main(String []args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++) {
            try{
            int castedValue = (int) myList.get(i);
            }
            catch(ClassCastException e){
                System.out.println("You can not cast stattment to int");
            }

        }
    }
}
