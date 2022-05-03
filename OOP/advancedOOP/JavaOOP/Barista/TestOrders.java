package OOP.JavaOOP.Barista;

public class TestOrders {
    private static boolean add;

    public static void main(String[] args) {
       
        // Menu items
        
        // Order variables -- order1, order2 etc. "Cindhuri", "Jimmy", "Noah", "Sam".
        Order order1=new Order();
        Order order2=new Order();

        Order order3=new Order("ahmad");
        Order order4=new Order("israa");
        Order order5=new Order("alaa");

        Item item1= new Item("apple", 5.5);
        Item item2= new Item("banana", 4.5);
        Item item3= new Item("rice", 50.8);

        order1.addItem(item1);
        order1.addItem(item2);
        order1.getStatusMessage();
        order1.display();

        order2.addItem(item1);
        order2.addItem(item2);
        order2.addItem(item3);
        order2.setReady(true);
        order2.getStatusMessage();
        order2.display();


        order3.addItem(item1);
        order3.addItem(item1);
        order3.addItem(item3);
        order3.getStatusMessage();
        order3.display();


        
        order4.addItem(item1);
        order4.addItem(item3);
        order4.display();
        order4.getStatusMessage();


        order5.addItem(item1);
        order5.addItem(item2);
        order5.addItem(item3);
        order5.addItem(item2);
        order5.setReady(true);
        order5.getStatusMessage();
        order5.display();







    }
}
