package com.company;
/*
 * File description: Exception class that inherits Exception, it is used to identify errors if the account user enter
 * a number that is not within the arrayList.
 * Student Name: Fady Shenouda
 * Student #: 041030674
 * Due Date: March 20th 2022
 * Professor Name: Abul Qasim
 * Course code: CST 8132
 */
/**
 * The purpose of this exception is to output an errorMessage if the account user entered is not a valid account.
 * @author Fady Shenouda
 * @version 2.0
 * @since 1.8
 */

public class AccountNotFoundException extends Exception{
    /**
     * The purpose of this exception is to output an errorMessage if the account user entered is not a valid account.
     * @author Fady Shenouda
     * @version 2.0
     * @since 1.8
     * @param errorMessage [Error message to display in the exception message.]
     *
     */

    public AccountNotFoundException(String errorMessage)
    {
     super(errorMessage);
    }
}
