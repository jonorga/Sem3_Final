/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/23/2023
 * File Name: Customer.java
 * Description: This file contains the Customer class. It contains a CreateEmailBehavior object, a method to 
 * return the email that was generated, and a method to set the customer type
 */
 
package email_generator;

public class Customer {
    CreateEmailBehavior createEmailBehavior;

    /**
     * This method sets the email strategy
     */
    public void SetCustomerType(CreateEmailBehavior createEmailBehavior) {
        this.createEmailBehavior = createEmailBehavior;
    }

    /**
     * This method gets the email from the create email behavior
     * @return String
     */
    public String GetEmail() { return createEmailBehavior.CreateEmail(); }
}