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
 * The purpose of this class is to save personal attributes
 * @author Fady Shenouda
 * @version 2.0
 * @since 1.8
 */

public class Person {
   public String firstName; //first name of person
    public String lastName; //last name of person
    public String email; //email of person
    public long phoneNum; // phone number of person

    /**
     * Constructor for person to save first name, last name, email and phone number of account holder.
     * @param firstName [first name of account holder]
     * @param lastName [last name of account holder]
     * @param email [email of account holder]
     * @param phoneNum [phone number of account holder]
     */
    public Person(String firstName, String lastName, String email, long phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    /**
     * getter of full name.
     * @return fullName
     */
    public String getFullName()
    {
        return firstName+" " +lastName;
    }

    /**
     *  Getter for phone number.
     * @return phoneNumber
     */
    public long getPhoneNum() {
        return phoneNum;
    }
}
