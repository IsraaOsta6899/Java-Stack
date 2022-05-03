package OOP.JavaOOP.Coffeedore;

import java.util.ArrayList;

public class CoffeeKiosk {
    static int index=0;
    ArrayList<Item> menu=new ArrayList<Item>();
    ArrayList<Order> orders= new ArrayList<Order>();
    public CoffeeKiosk(){
        menu= new ArrayList<Item>();
        orders=new ArrayList<Order>();
    }
    public void addMenuItem(String name , double price){

        Item newItem= new Item(name, price, index);
        index++;
        menu.add(newItem);
    }
    public void displayMenu(){
        for(Item i:this.menu){
            System.out.println(i.getIndex()+"  "+i.getName()+"--"+i.getPrice());
        }
    }
    public void newOrder() {
        
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order newOrder= new Order(name);
        
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            displayMenu();
            // Get the item object from the menu, and add the item to the order
            int itemnum=Integer.parseInt(itemNumber);
            Item orderItem = this.menu.get(itemnum);
            Order o= new Order(name);
            o.addItem(orderItem);
            this.orders.add(o);

            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
            
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        for(Order o : this.orders){
            o.display();
            System.out.println("---------");
        }
        
    }
}
