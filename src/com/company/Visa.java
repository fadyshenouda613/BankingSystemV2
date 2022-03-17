package com.company;
/*
 * File description: The purpose of this class is creating a visa credit card.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: March 20th 2022
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
/**
 * The purpose of this class is creating a visa credit card.
 * @author Fady Shenouda
 * @since 1.8
 */

public class Visa implements CreditCard {
     public long x = 4422123456781000L;
   private int j;

    /**
     * This is a getter for credit card number.
     * @return Visa credit card number
     */
    @Override
    public String getCreditCard()
    {
        if (j==999){
            return null;
        }
        else
        {
            x= x+j;
            String formatted = String.format("%04d   (V)",x);
            x = 4422123456781000L;
            return formatted;
        }
    }

    /**
     * Setter for the j.
     * @param j [last 3 digits of the credit card number XXX]
     */
    public void setJ(int j) {
        this.j = j;
    }
}
