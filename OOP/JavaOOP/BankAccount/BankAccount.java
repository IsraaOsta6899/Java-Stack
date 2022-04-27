package OOP.JavaOOP.BankAccount;

import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    static int accountsNumbers;
    double total;
    private String accountNumber="";
    public BankAccount(){
        accountsNumbers++;
        this.accountNumber=setAccountNumber();
    }
    public void setCheckingBalance(double amount){
        this.checkingBalance=amount;
    }
    public void setsavingsBalance(double amount){
        this.savingsBalance=amount;
    }
    private String setAccountNumber(){
        Random randMachine = new Random();
        for(int i=0 ; i<10;i++){
            int num=randMachine.nextInt(9 - 1) + 1;
            accountNumber+=num;
        }
        return accountNumber;

    }
    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    public void depositMoney(double amount){
        this.total=this.total+amount;
    }
    public void withdraw(double amount){
        if(amount>(this.savingsBalance+this.checkingBalance)){
            System.out.println("you can not withdraw this amount of money , you have less than this amount in tour account");
        }
        else{
            System.out.println("you can");
            System.out.println("befor withdraw you have :  "+ (this.savingsBalance+this.checkingBalance));
            this.savingsBalance-=amount;
            System.out.println("after withdraw you have :  "+ (this.savingsBalance+this.checkingBalance));

        }
    }
    public void displayTotalMoney(){
        System.out.println(this.savingsBalance+this.checkingBalance);

    }
}
