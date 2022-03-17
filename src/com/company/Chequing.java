package com.company;
/*
 * File description: his class is responsible for depositing money into chequing accounts, creating chequing account
 *  and withdrawing money.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: March 20th 2022
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
/**
 * This class is responsible for depositing money into chequing accounts, creating chequing account and withdrawing money.
 * @author Fady Shenouda
 * @version 2.0
 * @since 1.8
 */
public class Chequing extends Account{
    private static final double fee = 1.5; //transaction fee, it's a constant that does not change.


    /**
     * Creates an account when called using super()
     * No parameter constructor.
     */
    //constructor that creates an account when chequing is called
    public Chequing() {
        super();
    }

    /**
     * Deposit money method
     * @param deposit deposit amount the user wishes to input
     */
    //money deposit method
    @Override
    public void depositMoney(double deposit){
        balance= super.getBalance();
        balance+= deposit;
        if (balance<=3000){
            balance-=fee;
        }
        super.setBalance(balance);
    }

    /**
     * Withdraw money method.
     * @param withdraw withdraw amount the user wishes to withdraw
     */
    @Override
    //money withdrawal method.
    public void withdrawMoney(double withdraw){

        balance= super.getBalance();
        balance-= withdraw;
        if (balance<=3000){
            balance-=fee;
        }
        super.setBalance(balance);
    }

}
