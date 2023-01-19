/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atmsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author Johannah Magadia; 11-Python
 */
public class AtmSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Setting up input reader here using BufferedReader
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        
        char login = ' ';
        
        System.out.println("===============Welcome to Kopii's ATM Machine!===============");
        
        //main menu
        do {
            System.out.println("Select an option from the menu below: ");
            System.out.println("L : Login");
            System.out.println("C : Create New Account");
            System.out.println("Q : Quit");
            System.out.print("> ");
            
            try {
                login = reader.readLine().charAt(0);//get the first character of the string input
            } catch (IOException ex) {
                Logger.getLogger(AtmSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if ( login == 'L' || login == 'l') {
                System.out.print("Enter User ID: ");
                Scanner sc = new Scanner(System.in);
                String userId = sc.nextLine();
                System.out.print("Enter password: ");
                String userPw = sc.nextLine();
                System.out.println("----LOGIN FAILED----");
                System.out.println(" ");
            } else if ( login == 'Q' || login == 'q') {
                System.out.println("========Thank you for using Kopii's ATM Machine!========");
                System.exit(0);
            } else if ( login == 'C' || login == 'c') {
                break;
            } else
                System.out.println("----ERROR. TRY AGAIN.----");
            
        } while ( login != 'C' || login != 'c');
        
        //creating an account
        System.out.print("Enter new User ID:        ");
        Scanner sc = new Scanner(System.in);
        String newUn = sc.nextLine();
        System.out.print("Enter new Password:       ");
        String newPass = sc.nextLine();
        System.out.print("Confirm new Password:     ");
        String confPass = sc.nextLine();
        
        if (newPass.equals(confPass)) {
            System.out.println("Your account has been registered.");
            System.out.println("================================");
            System.out.println(" ");
        } else if (newPass != confPass) {
            System.out.println("Authentication Failed! Please try again.");
            System.exit(0);
        }
            
        //logging in new account
        OUTER:
        do {
            System.out.println("Select an option from the menu below: ");
            System.out.println("L : Login");
            System.out.println("C : Create New Account");
            System.out.println("Q : Quit");
            System.out.print("> ");
        
            try {
                login = reader.readLine().charAt(0);//get the first character of the string input
            } catch (IOException ex) {
                Logger.getLogger(AtmSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            switch(login) {
                case 'L':
                case 'l':
                    System.out.print("Enter User ID:  ");
                    String userId = sc.nextLine();
                        if (userId.equals(newUn)) {
                            System.out.print("Enter password: ");
                            String userPw = sc.nextLine();
                            if (userPw.equals(newPass)) {
                                System.out.println("----Access Granted!----");
                                break OUTER;
                            } else {
                                System.out.print("----Incorrect. Exiting Now...----");
                                System.exit(0);
                            }
                        } else {
                            System.out.print("----Incorrect. Exiting Now...----");
                            System.exit(0);
                        }
                case 'C':
                case 'c':
                    System.out.println("----Command unavailable. Please try again later.----");
                    System.out.println(" ");
                    break;
                case 'Q':
                case 'q':
                    System.out.println("========Thank you for using Kopii's ATM Machine!========");
                    System.exit(0);
                default:
                    System.out.println("----ERROR. TRY AGAIN.----");
                    System.out.println(" ");
                    break;
            }
        } while ( login != 'L' || login != 'l');
        
        //atm dashboard
        System.out.println(" ");
        System.out.println("========Welcome to the ATM Dashboard!========");
        System.out.println(" ");
        
        char atmIn = ' ';
        double deposit = 0;
        double withdraw = 0;
        double balance = 0;
        
        OUTER:
        do {
            System.out.println("What would you like to do?");
            System.out.println("D : Deposit");
            System.out.println("W : Withdraw Money");
            System.out.println("B : Check Balance");
            System.out.println("Q : Quit");
            System.out.print("> ");
            try {
                atmIn = reader.readLine().charAt(0);//get the first character of the string input
            } catch (IOException ex) {
                Logger.getLogger(AtmSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (atmIn) {
                case 'D':
                case 'd':
                    System.out.print("Amount of deposit:  $");
                    try {
                        deposit = Double.parseDouble(reader.readLine());
                    } catch (NumberFormatException ex) { //catches errors on inputs that aren't numbers
                        System.out.println("----Wrong Input. Exiting Program...----");
                        System.exit(0);
                    } catch (IOException ex) { //catches Input/Output errors
                        Logger.getLogger(AtmSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    balance = balance + deposit;
                    System.out.println("Success!");
                    System.out.println("Current balance is: $" + balance);
                    System.out.println("-----------------");
                    System.out.println(" ");
                    break ;
                case 'W':
                case 'w':
                    System.out.print("Amount of withdrawal:   $");
                    try {
                        withdraw = Double.parseDouble(reader.readLine());
                    } catch (NumberFormatException ex) { //catches errors on inputs that aren't numbers
                        System.out.println("----Wrong Input. Exiting Program...----");
                        System.exit(0);
                    } catch (IOException ex) { //catches Input/Output errors
                        Logger.getLogger(AtmSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (balance < withdraw) {
                        System.out.println("Insufficient balance!");
                        System.out.println("-----------------");
                        System.out.println(" ");
                    } else if (balance >= withdraw ) {
                        balance = balance-withdraw;
                        System.out.println("Success!");
                        System.out.println("Current balance is: $" + balance);
                        System.out.println("-----------------");
                        System.out.println(" ");
                    }   break;
                case 'B':
                case 'b':
                    System.out.println("Current balance is: $" + balance);
                    System.out.println("-----------------");
                    System.out.println(" ");
                    break;
                case 'Q':
                case 'q':
                    break OUTER;
                default:
                    System.out.println("----ERROR. TRY AGAIN.----");
                    System.out.println(" ");
                    break;
            }
        } while (atmIn != 'Q' || atmIn != 'q');
        
        System.out.println("");
        System.out.println("===============Thank you for using Kopii's ATM Machine!===============");

        System.exit(0);
    }
    
}
