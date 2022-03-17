package com.company;
/*
 * File description: Main class, has all menu options. The driver class is responsible for calling other methods to
 * function.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: March 20th 2022
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */

import java.util.Scanner;
/**
 * The purpose of this class is to loop through menu options and read accounts / transactions / print all accounts and applying for a credit card.
 * @author Fady Shenouda
 * @since 1.8
 */

public class Main {


    public static void main(String[] args){
        //menu option
        int option;

        // boolean to know if the menu is continuing
        boolean menuOn = true;

        //scanner declaration
        Scanner scanner=new Scanner(System.in);

        //input name of the bank
        System.out.println("Enter the name of the bank: ");

        // create new bank object sending the name of the bank as a parameter in the object.
        Bank bank = new Bank(scanner.nextLine());

            while (menuOn) { //while menuOn is true
                try {
                    //output options
                    System.out.println("1.Create Account");
                    System.out.println("2.Transactions");
                    System.out.println("3.Print all Accounts");
                    System.out.println("4.Apply for a Credit Card");
                    System.out.println("5.Exit");
                    option = scanner.nextInt();
                }
               catch (Exception e){ //catch all exceptions including InputMissMatchException
                    System.out.println("Invalid menu option.Try again...");
                    scanner.next();
                    continue;
                }
                switch (option) {
                    //switch-case to function methods depending on user-inputted message- default is
                    //if user inputs a number other than 1,2,3,4,5.
                    case 1 -> bank.readAccounts(scanner); //reads account
                    case 2 -> bank.transaction(scanner); //makes a transaction/show balance
                    case 3 -> bank.printAll(); //prints all accounts with head title.
                    case 4 -> bank.creditCard(scanner); //applies for credit card.
                    case 5 -> menuOn = false; // exit option
                    default -> System.out.println("Invalid menu option. Try again....");
                }
            }
            scanner.close(); //closes scanner
        //outputs once the user chooses to exit the program.
        System.out.println("**** Program is now closing. Thank you for trying it out.****");
        System.out.println("Programmed by Fady Shenouda.");
        }
    }

