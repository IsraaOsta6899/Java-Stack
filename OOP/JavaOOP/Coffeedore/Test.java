package OOP.JavaOOP.Coffeedore;

public class Test {
    public static void main(String []args){
        Item item1= new Item("apple", 5.5,1);
        Item item2= new Item("banana", 4.5,2);
        Item item3= new Item("rice", 50.8,3);
        CoffeeKiosk c= new CoffeeKiosk();

        c.addMenuItem("botato", 3.8);
        c.addMenuItem("orange", 5.8);
        c.addMenuItem("strobery", 7.8);
        c.newOrder();
        c.addMenuItem("botato", 3.8);
        c.newOrder();
    
        
    }
    
}
