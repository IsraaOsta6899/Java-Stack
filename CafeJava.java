public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice=4.5;
        double latte=5.5;
        double cappuccino=6.5;

       
       
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if(isReadyOrder2){
        System.out.println(generalGreeting + customer2+ readyMessage);
        }
        else{
            System.out.println(generalGreeting + customer2+ pendingMessage);

        }
        if(isReadyOrder2){
            System.out.println(generalGreeting + customer2+ readyMessage);
            }
        else{
                System.out.println(generalGreeting + customer2+ pendingMessage);
    
            }
        if(isReadyOrder3){
                System.out.println(generalGreeting + customer3+ readyMessage);
            }
        else{
                System.out.println(generalGreeting + customer3+ pendingMessage);
        
            }
        if(isReadyOrder4){
                System.out.println(generalGreeting + customer4+ readyMessage);
            }
        else{
                System.out.println(generalGreeting + customer4+ pendingMessage);
            
            }
        /*Noah ordered a cappuccino. Use an if statement to check the status of his order and print the correct status message. 
        If it is ready, also print the message to display the total
        . Note: Outcomes may be different depending on what you assigned as the status. */
      
        if(isReadyOrder4){
            System.out.println(customer4+readyMessage+displayTotalMessage+cappuccino);
            

        }
        else{
            System.out.println(customer4+pendingMessage);

        }
        if(isReadyOrder2){
            System.out.println(generalGreeting + customer2+isReadyOrder2);
            System.out.println(customer2+readyMessage+displayTotalMessage+cappuccino*2);
            

        }
        else{
            System.out.println(customer2+pendingMessage);

        }
        isReadyOrder2=false;
        if(isReadyOrder2){
            System.out.println(generalGreeting + customer2+isReadyOrder2);
            System.out.println(customer2+readyMessage+displayTotalMessage+cappuccino*2);
            

        }
        else{
            System.out.println(customer2+pendingMessage);

        }
        System.out.println(customer3 + "you are owes by "+(latte-dripCoffeePrice));



    }
}