package OOP.JavaOOP.OrdersAndItems;

public class TestOrders {
    private static boolean add;

    public static void main(String[] args) {
       
        // Menu items
        Item item1= new Item();
        Item item2= new Item();
        Item item3= new Item();
        Item item4= new Item();
        item1.name="mocha";
        item1.price=5.5;

        item2.name="latte";
        item2.price=10.5;

        item3.name="drip coffee";
        item3.price=15.5;

        item4.name="capuccino";
        item4.price=25.5;

        // Order variables -- order1, order2 etc. "Cindhuri", "Jimmy", "Noah", "Sam".
        Order order1= new Order();
        order1.name="Cindhuri";

        Order order2= new Order();
        order2.name="Jimmy";
        order2.items.add(item1);
        order2.total=order2.total+1;

        Order order3= new Order();
        order3.name="Noah";
        order3.items.add(item4);
        order3.total++;

        Order order4= new Order();
        order4.name="Sam";
        order4.items.add(item2);
        order4.total++;


        order1.ready=true;

        order3.items.add(item4);
        order3.total++;
        
        order2.ready=true;
    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}
