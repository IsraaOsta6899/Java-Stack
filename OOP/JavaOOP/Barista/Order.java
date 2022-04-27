package OOP.JavaOOP.Barista;

import java.util.ArrayList;

public class Order {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items=new ArrayList<Item>();
    public Order(){
        this.name="Guest";
        this.items= new ArrayList<Item>();
    }
    public Order(String name){
        this.name=name;
        
    }
    public void addItem(Item item){
        this.items.add(item);
    }
    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready.";
        }
        else{
            return "Thank you for waiting. Your order will be ready soon.";
        }
        
    }
    public void display(){
      
        System.out.println("Customer Name"+ this.name);
        double total=0;
        for(Item item:this.items){
            System.out.println(item.getName()+"-"+item.getPrice());
            total+=item.getPrice();
        }
        System.out.println("Total="+total);

    }
    public double getOrderTotal(){
        double total=0;
        for(Item item:this.items){
            total+=item.getPrice();
        }
       return total;
    }
    public void setReady(boolean b){
        this.ready=b;
    }


}
