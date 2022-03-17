package com.company;
/*
 * File description: Account class, this class is an abstract class it is made an array list from and it sends all
 * personal information to class person.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: March 20th 2022
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
import java.util.Scanner;

/**
 * The purpose of this class is to be the connection between bank class and chequing and savings
 * @author Fady Shenouda
 * @version 2.0
 * @since 1.8
 */

public abstract class Account{
   private Person accHolder; //acc holder object from person
    public double balance; //balance variable
   private static int numberofAccounts; //number of accounts entered variable
    public int accountNumber; //account number that the customer wants to edit
    Visa visa = new Visa(); //visa object.
    MasterCard masterCard = new MasterCard(); //master card object
   public String creditCard; //credit card number
   private static int k; //The last 3 digits of the mastercard(MC) or visa(V)
    public Account() {
        accountNumber=numberofAccounts;
        numberofAccounts++;
    }

    public Account(Person accHolder) {
        this.accHolder = accHolder;
    }

    /**
     * Setter for balance
     * @param balance the balance of the account
     */
    //balance setter
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * adds a credit card to the account
     * @param option option of the visa or chequings
     */
    // Adding a credit card to an account object.
    public void addCreditCard(int option)
    {
        if (option==1){
            if (visa.getCreditCard()==null){
                System.out.println("The credit cards are already full!.");
                return;
            }
               masterCard.setJ(k);
            k++;

            creditCard = masterCard.getCreditCard();

        }
        if (option==2){
            if (visa.getCreditCard()==null){
                System.out.println("The credit cards are already full!.");
                return;
            }
                visa.setJ(k);
            k++;

            creditCard = visa.getCreditCard();

        }
    }

    /**
     * Reads details of the account
     * @param scanner scanner object that scans user inputs.
     */
    //Reads personal attributes and sends them to person class.
    public void readDetails(Scanner scanner)
    {
        boolean menuOn=true;
        String firstName = null,lastName = null,email = null;
        long phoneNum = 0;

            do {
                try {

                    System.out.println("Let's get to know our new customer: ");
                    System.out.println("Enter first name: ");
                    scanner.nextLine();
                    firstName = scanner.nextLine();
                    System.out.println("Enter last name: ");
                    lastName = scanner.nextLine();
                    System.out.println("Enter email: ");
                    email = scanner.nextLine();
                    System.out.println("Enter phone number: ");
                    phoneNum = scanner.nextLong();
                }
                catch(Exception e){
                    System.out.println("You have entered an invalid input.");
                    scanner.next();
                    continue;
                }
                    menuOn = false;


            }while (menuOn);
            accHolder = new Person(firstName, lastName, email, phoneNum);




    }

    /**
     * Deposit money method
     * @param deposit deposit amount the user wishes to input
     */
    //abstract method for money deposit
    abstract void depositMoney(double deposit);

    /**
     * Withdraw money method
     * @param withdraw withdraw amount the user wishes to withdraw
     */
    // abstract method for money withdrawal
    abstract void withdrawMoney(double withdraw);

    /**
     * Getter of account holder full name.
     * @return the full name of the account holder
     */
    // get full name of the person by combining firstName + lastName.
    public String getFullName()
    {
        return accHolder.getFullName();
    }

    /**
     * getter for account holder email.
     * @return the email of the account holder
     */
    //getter for email
    public String getEmail(){
        return accHolder.email;
    }

    /**
     * Getter for person's phone number.
     * @return the phone number of the account holder
     */
    //getter for phone number.
    public long getPhoneNum(){
        return accHolder.getPhoneNum();
    }

    /**
     * Getter for balance of the account.
     * @return the account balance of the account holder
     */
    //getter for account balance.
    protected double getBalance() {
        return balance;
    }
}
