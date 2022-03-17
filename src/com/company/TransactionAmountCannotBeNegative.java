package com.company;
/*
 * File description: The purpose of this exception is that transaction amount cannot be negative.
 *  (You cannot deposit negative money nor withdraw)
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: March 20th 2022
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
/**
 * The purpose of this exception is that transaction amount cannot be negative. (You cannot deposit negative money nor
 * withdraw)
 * @author Fady Shenouda
 * @version 2.0
 * @since 1.8
 */

public class TransactionAmountCannotBeNegative extends Exception{

    public TransactionAmountCannotBeNegative(String errorMessage)
    {
        super(errorMessage);
    }
}
