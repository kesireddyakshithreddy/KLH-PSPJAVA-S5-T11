import java.util.Scanner;

public class Atmproject {
    // CO3: Method to show balance
    static void showBalance(double balance) {
        System.out.println("Balance: " + balance); // CO3: Method
    }

    public static void main(String[] args) {
        // CO1: Datatypes & Variables
        int pin = 1969;   
        double balance = 1000000; 
        double[] history = new double[5]; // CO3: Array for transactions
        int count = 0; 
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert your card...");
        System.out.println("Card inserted successfully!");
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();
        if (enteredPin != pin) {
            System.out.println("Wrong PIN!");
            return;
        }

        int option;
        // CO2: Loop + Switch Case
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            option = sc.nextInt();

            switch(option) {
                case 1: 
                    showBalance(balance); // CO3: Method 
                    break;
                case 2: 
                    System.out.print("Deposit: "); 
                    double d = sc.nextDouble(); 
                    balance += d; 
                    history[count++] = d; // store deposit in array
                    System.out.println("Deposited: " + d);
                    break;
                case 3: 
                    System.out.print("Withdraw: "); 
                    double w = sc.nextDouble(); 
                    if(w <= balance) { 
                        balance -= w; 
                        history[count++] = -w; 
                        System.out.println("Withdrawn: " + w);
                    } else {
                        System.out.println("Insufficient!");
                    } 
                    break;
                case 4: 
                    System.out.println("Transaction History:");
                    for(int i=0; i<count; i++) {
                        System.out.println(history[i]);
                    }
                    break;
                case 5: 
                    System.out.println("Thank you! Please take your card."); 
                    break;
                default: 
                    System.out.println("Invalid option!");
            }
        } while(option != 5); // loop continues until Exit
    }
}

