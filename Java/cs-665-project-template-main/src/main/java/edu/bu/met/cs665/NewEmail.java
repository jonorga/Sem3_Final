/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/23/2023
 * File Name: NewEmail.java
 * Description: This file contains the NewEmail class, it contains the create email method to generate
 * an email for a new customer
 */
 
package email_generator;

public class NewEmail implements CreateEmailBehavior {
    
    /**
     * This method creates the email to return to the customer class
     * @return String
     */
    public String CreateEmail() {
        return "Welcome! we are reaching out regarding our new business partnership.";
    }
}