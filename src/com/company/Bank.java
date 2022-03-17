package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/*
 * File description: Bank Class. The purpose of this class to be the backend of the main class that
 *  has all the methods that is called in main. This class is responsible to call specific functions from other classes
 *  in order to offer transactions,reading account and printing all accounts.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: March 20th 2022
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
/**
 * The purpose of this class to be the backend of the main class that has all the methods that is called in main.
 * This class is responsible to call specific functions from other classes in order to offer transactions,reading
 * account and printing all accounts.
 * @author Fady Shenouda
 * @version 2.0
 * @since 1.8
 */
public class Bank { //bank class
    // the option the customer will choose
    int option;
    // menuOn is a boolean to check if customer is done with seeing a specific menu
    boolean menuOn = true;
    //name of the bank
    String name;
    //array list of customer accounts
    ArrayList<Account> accounts;
    // the account number.
    int accountNumber=0;

    /**
     * Constructor that receives name of the bank and sets it, this constructor creates an account arraylist as well.
     * @param name [name of the bank]
     */
    public Bank(String name) { //constructor that creates arraylist and sets the name of bank
        this.name = name;
        accounts = new ArrayList<>();
    }

    /**
     * This method reads the account type and creates a chequing or a saving upon customer request.
     * @param scanner [scanner object]
     */
    /*
    * method on reading account information
    */

    public void readAccounts(Scanner scanner){
        menuOn=true;

        while (menuOn){
            try {
                //chequing or saving option
                System.out.println("1.Chequing");
                System.out.println("2.Saving");
                option=scanner.nextInt();
                //catch any exception
            }catch (Exception e){
                System.out.println("Invalid menu option.Try again...");
                scanner.next();
                continue;
            }

            // switch case to check if customer wants a chequing or a savings account.
            switch (option) {
                //case 1 new chequing account
                case 1 -> {

                    accounts.add(new Chequing());
                    accounts.get(accounts.size() - 1).readDetails(scanner);
                    printDetails();
                    menuOn = false;
                }
                //case 2 new savings account
                case 2 -> {
                    accounts.add(new Savings());
                    accounts.get(accounts.size() - 1).readDetails(scanner);
                    printDetails();
                    menuOn = false;
                }
                //default if customer enters a number different than 1 or 2.
                default -> System.out.println("**** Enter Valid Account Type ****");
            }
            accountNumber+=1;
        }
    }

    /**
     * This method is responsible for transactions including withdraw, deposit and balance
     * @param scanner [scanner object]
     */
    // This method is responsible for transactions including withdraw, deposit and balance
    public void transaction (Scanner scanner){
        boolean menuOn = true;
        int accountNumber;
        int option;
        double amount = 0;
        if (accounts.isEmpty()) { //if there is no accounts in the array list output the following..
            System.out.println("You need to create an account first.");
            return;
        }

        while (menuOn) {
            printDetails();
            try {

                 /*
                *if customer enters a wrong number that is a string or an account number that is outside of the array
                *list it catches the exception and responsively respond to it.
                */
                System.out.println("Enter account number: ");
                accountNumber = scanner.nextInt();

                if (accounts.size() < accountNumber) {
                    throw new AccountNotFoundException("Account number entered " + accountNumber + " is not found. Try again...");
                }
            } catch (AccountNotFoundException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Invalid menu option. Try again...");
                scanner.next();
                continue;
            }

            while (menuOn) {
                try {
                    /*
                     this is the transaction steps, customer either chooses deposit,withdraw or to see balance
                     case 1 is deposit, case 2 is withdraw, case 3 is balance
                     */
                    System.out.println("1.Deposit");
                    System.out.println("2.Withdraw");
                    System.out.println("3.Balance");
                    option = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid menu option. Please try again...");
                    scanner.next();
                    continue;
                }
                switch (option) {
                    case 1: //deposit
                            do {
                                try {
                                    System.out.println("Enter the amount to deposit: ");
                                    amount = scanner.nextDouble();
                                    if (amount < 0) {
                                        throw new TransactionAmountCannotBeNegative("Transaction amount cannot be negative.");
                                    }
                                }catch (TransactionAmountCannotBeNegative e) {
                                    System.out.println(e.getMessage());
                                   continue;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid deposit amount...");
                                    scanner.next();
                                  continue;
                                }
                                accounts.get(accountNumber - 1).depositMoney(amount);
                                printDetails();
                                menuOn = false;

                            } while (amount < 0);
                            break;

                    case 2:
                        do {
                        try { //withdraw
                                System.out.println("Enter the amount to withdraw: ");
                                amount = scanner.nextDouble();
                                if(amount<0){
                                    throw new TransactionAmountCannotBeNegative("Transaction amount cannot be negative..");
                                }
                                if(amount> accounts.get(accountNumber-1).balance){
                                    throw new InsufficientFundException("Balance is not enough to withdraw " + amount +".\nAccount balance is " +accounts.get(accountNumber-1).balance);
                                }
                            }catch (TransactionAmountCannotBeNegative | InsufficientFundException e){
                            System.out.println(e.getMessage());
                            continue;
                        }
                        catch (InputMismatchException e){
                            System.out.println("Enter a valid withdrawal amount...");
                            continue;
                        }

                            accounts.get(accountNumber - 1).withdrawMoney(amount);
                            printDetails();
                            menuOn = false;
                        }while(amount<0);
                        break;
                    case 3: //balance
                        System.out.println("Account balance: " + accounts.get(accountNumber - 1).getBalance());
                        menuOn = false;
                        break;
                    default:
                        System.out.println("Invalid Menu Option");


                }

            }

        }
    }


    /**
     * Prints all accounts information with a header.
     */
    public void printAll() {
        /*
        this method prints all of the accounts information with a bank header.
         */
        if (accounts.isEmpty()) {
            System.out.println("You need to create an account first.");
            return;
        }
        else {
            System.out.printf("************************************************************************************************************\n%50s BANK\n",name.toUpperCase(Locale.ROOT));
            printDetails();
        }
    }

    /**
     * Credit card menus and method caller.
     * @param scanner [scanner object]
     */
    /*
     * Credit card method that creates a credit card for customers once applied
     */
    public void creditCard(Scanner scanner) {
        boolean menuOn = true;
        int num = 0;
        int option=0;
        if (accounts.isEmpty()) {
            System.out.println("You need to create an account first.");
            return;
        }
        else {
            do {
                try {
                    System.out.print("Enter account number: ");
                    num = scanner.nextInt();
                    if (accounts.size()<num | num<=0) {
                        throw new AccountNotFoundException("Account number entered "+ num + " is not found. Try again...");
                    }
                    do {


                        System.out.println("1.MasterCard");
                        System.out.println("2.Visa");
                        option = scanner.nextInt();
                        if (option!=1 & option!= 2) System.out.println("Wrong selection. Retry...");

                    }while (option!=1 & option!=2);


                } catch (InputMismatchException e) {
                    System.out.println("Invalid menu option. Try again...");
                    scanner.next();
                    continue;
                }
                catch (AccountNotFoundException e) {
                    System.out.println(e.getMessage());
                    continue;

                }
                menuOn=false;

            } while (menuOn);
        }
        accounts.get(num - 1).addCreditCard(option);
    }

    /**
     * Prints details of the accounts.
     */
         /*
          * This method is responsible to print all account information without the bank header.
          */
    public void printDetails()
    {
        System.out.printf("************************************************************************************************************\nAcc number |          Name         |          Email               |   Phone Number | Balance|    Credit Card\n************************************************************************************************************\n");
        for (int i = 0;i<=accounts.size()-1;i++) {
            System.out.printf("%6d     | %20.20s  |   %26.26s |   %11d  |  %.2f  |", accounts.get(i).accountNumber+1, accounts.get(i).getFullName(), accounts.get(i).getEmail(), accounts.get(i).getPhoneNum(), accounts.get(i).balance);
            if (accounts.get(i).creditCard == null) {
                System.out.printf("\n");
            }
            else {
                System.out.printf("%s  \n", accounts.get(i).creditCard);
            }
        }
    }
}
