package com.company;
/*
 * File description: The purpose of this class to create a saving account.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: March 20th 2022
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */

/**
 * The purpose of this class to create a saving account.
 * @author Fady Shenouda
 * @version 2.0
 * @since 1.8
 */

public class Savings extends Account{

    private static final double fee = 0.5; //the constant fee of transactions

    /**
     * constructor with no parameter, creates an account once called.
     */
    public Savings() { //constructors no parameter
        super();
    }

    /**
     * Withdraw money method.
     * @param withdraw withdraw amount the user wishes to withdraw
     */
    @Override
    public void withdrawMoney(double withdraw) //withdraw method (withdraws money from the bank account balance
    {
     balance-=withdraw;
     balance-=fee;
     super.setBalance(balance);
    }

    /**
     * Deposit money method.
     * @param deposit deposit amount the user wishes to input
     */
    @Override
    public void depositMoney(double deposit){ //deposit method (deposits money into the bank account balance)
        balance+=deposit;
        balance-= fee;
        super.setBalance(balance);
    }

}
