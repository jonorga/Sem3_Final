/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/23/2023
 * File Name: VIPEmail.java
 * Description: This file contains the VIPEmail class, it contains the create email method to generate
 * an email for a VIP customer
 */
 
package email_generator;

public class VIPEmail implements CreateEmailBehavior {
    
    /**
     * This method creates the email to return to the customer class
     * @return String
     */
    public String CreateEmail() {
        return "To our most valued customer, we are reaching out to let you know we value your business.";
    }
}