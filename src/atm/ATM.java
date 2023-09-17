package atm;
import java.util.Scanner;
 /**
 * @author Hp
 */
///////////// BANK CLASS
class Bankaccount{
    private double balance;
    public Bankaccount(double initialBalance){
        this.balance = initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void Deposit(double Amount){
    balance += Amount;
    }
    public boolean Withdraw(double Amount){
    if(Amount <= balance){
        balance -= Amount;
        return true;
    }
    return false;
    }
}
// ///////////ATM CLASS
class _ATM{
    private Bankaccount account;
    private Scanner scanner;
    
    public _ATM(Bankaccount account){
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void Menu(){
        System.out.print("************* ATM MENU *************");
        System.out.print("\n1: DEPOSIT ");
        System.out.print("\n2: WITHDRAW ");
        System.out.print("\n3: CHECK BALANCE ");
        System.out.print("\n4: EXIT");
    }
    public void Deposit(){
        System.out.print("Enter Deposit Amount: "); 
        double Amount = scanner.nextDouble();
        account.Deposit(Amount);
        System.out.println("Money Deposited : "+Amount);
    }
    public void Withdraw(){
        System.out.print("Enter Withdrawl Amount: "); 
        double Amount = scanner.nextDouble();
        if(account.Withdraw(Amount)){
            System.out.println("Withdraw Amount: "+Amount);
        } else{
         System.out.println("Insufficient Balance!!"); 
        }
    }
    public void Checkbalance(){
        System.out.println("Current Balance Is: "+account.getBalance());
    }
    public void Run(){
        int choice;
        do{
            Menu();
            System.out.println("\nEnter Your Choice");
            choice = scanner.nextInt();
            
            switch (choice){
                case 1:
                    Deposit();
                    break;
                case 2:
                    Withdraw();
                    break;
                case 3:
                    Checkbalance();
                    break;
                case 4: 
                    System.out.println("Exiting ATM!");
                    break;
                default:
                    System.out.println("Try Again.Invalid Choice!!");
            }
        } while (choice != 4);
    }
}
public class ATM {

    public static void main(String[] args) {
        // TODO code application logic here
        Bankaccount userAccount = new Bankaccount (100.00); //Initial Balance
        _ATM atm = new _ATM(userAccount);
        atm.Run();
    }
    
}
