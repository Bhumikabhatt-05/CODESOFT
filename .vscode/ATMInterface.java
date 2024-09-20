import java.util.Scanner;
//creating a class named bankAccount to represent balance and maintain operation.

class BankAccount{
    private double balance ;
    public BankAccount(double intialBalance){
        this.balance = intialBalance ;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance += amount ;
        }else{
            System.out.println("Deposit amount should be positive");
        }
    }
    public boolean withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance -= amount ;
            return true ;
        }else{
            return false ;
        }
    }
}
//creating a class ATM to handle the display and other operations to be carried out....

class ATM{
    private BankAccount account;
    public ATM(BankAccount account){
        this.account = account;
    }
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int option ;
        do{
            System.out.println("ATM ");
            System.out.println("1 = Check Balance");
            System.out.println("2 = Deposit amount");
            System.out.println("3 = Withdraw amount");
            System.out.println("4 = Exit");
            System.out.println("Select the option");
            option = sc.nextInt();
            switch(option){
                case 1 :
                    checkBalance();
                    break;
                case 2 :
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for your visit");
                    break;
                default:
                    System.out.println("invalid option");
            }
        }while(option!=4);
    }
        private void checkBalance(){
            System.out.printf("Current Account Balance is : Rs%.2f%n", account.getBalance());
        }
        private void deposit(){
            System.out.println("Enter deposit amount : ");
            Scanner sc = new Scanner(System.in);
            double amount = sc.nextDouble();
            account.deposit(amount);
            System.out.println("Amount is deposited Successfully....");
        }
        private void withdraw(){
            System.out.println("enter withdrawal amount:");
            Scanner sc = new Scanner(System.in);
            double amount = sc.nextDouble();
            if(account.withdraw(amount)){
                System.out.println("Amount is withdrawn successfully");
            }else{
                System.out.println("Insufficent balance or invalid amount");
            }

        }
    
}
public class ATMInterface{
    public static void main(String[] args){
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        atm.menu();
    }
}