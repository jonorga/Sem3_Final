/**
 * Name: Jon Organ
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/23/2023
 * File Name: FrequentEmail.java
 * Description: This file contains the FrequentEmail class, it contains the create email method to generate
 * a frequent email
 */
 
package email_generator;

public class FrequentEmail implements CreateEmailBehavior {
    
    /**
     * This method creates the email to return to the customer class
     * @return String
     */
    public String CreateEmail() {
        return "Hello again! we are reaching out regarding our continuing business together.";
    }
}