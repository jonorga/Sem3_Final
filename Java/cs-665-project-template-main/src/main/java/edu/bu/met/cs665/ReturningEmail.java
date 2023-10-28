/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/23/2023
 * File Name: ReturningEmail.java
 * Description: This file contains the ReturningEmail class, it contains the create email method to generate
 * a returning email
 */
 
package email_generator;

public class ReturningEmail implements CreateEmailBehavior {
    
    /**
     * This method creates the email to return to the customer class
     * @return String
     */
    public String CreateEmail() {
        return "Welcome back, we are reaching out regarding to your renewal of our services.";
    }
}