package com.company;
/*
 * File description: The purpose of this exception is to output an errorMessage when there is not enough money to
 * withdraw in the bank account.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: March 20th 2022
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */

/**
 * The purpose of this exception is to output an errorMessage when there is not enough money to withdraw in the bank account.
 * @author Fady Shenouda
 * @version 2.0
 * @since 1.8
 */
public class InsufficientFundException extends Exception{
    /**
     *
     * @param errorMessage [Error message to output when there is not enough money]
     */
    public InsufficientFundException(String errorMessage)
    {
        super(errorMessage);
    }
}
