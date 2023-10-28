/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/23/2023
 * File Name: BusinessEmail.java
 * Description: This file contains the BusinessEmail class, it contains the create email method to generate
 * a business email
 */
 
package email_generator;

public class BusinessEmail implements CreateEmailBehavior {

    /**
     * This method creates the email to return to the customer class
     * @return String
     */
    public String CreateEmail() {
        return "To whom it may concern, we are reaching out regarding this business email.";
    }
}