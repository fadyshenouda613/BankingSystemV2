package com.company;
/*
 * File description:The purpose of this class to create a mastercard card number for bank accounts.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: March 20th 2022
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
/**
 * The purpose of this class to create a mastercard card number for bank accounts.
 * @author Fady Shenouda
 * @version 2.0
 * @since 1.8
 */
public class MasterCard implements CreditCard{
   static long x =  5522123456781000L;
     private int j;

    /**
     * The credit card creator method.
     * @return null if the last 3 digits XXX are 999 else [masterCard number]
     */
    @Override
    public String getCreditCard()
    {
        if (j==999){
            return null;
        }
        else
        {
            x=x+j;
            String formatted = String.format("%04d   (MC)",x);
            x =  5522123456781000L;
            return formatted;
        }

    }

    /**
     * Setter for the number at the end of the master card number XXX.
     * @param j [the number of the xxx at the end of the master card number]
     */

    public void setJ(int j) {
        this.j = j;
    }

}
