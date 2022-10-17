
@tag
Feature: Customer access to non-permitted sections
  As a customer I should not access and manage 
  Admin module, Agents module or Supplier module

  @AdminModuleAccess
  Scenario: Check customer is not able to access Admin Module
    Given I login to Admin portal with Emailid as "qatech@gmail.com"
    When I enter the password as "qatech@123"
    And I click Admin Login button
    Then I validate error message
  
    
  @AgentsModuleAccess
  Scenario: Check customer is not able to access Agents Module
    Given I login to Agents portal with Emailid as "qatech@gmail.com"
    When I enter password as "qatech@123"
    And I click Login button
    Then I validate the error message displayed
  
    
   @SupplierModuleAccess
   Scenario: Check customer is not able to access Supplier Module
    Given I login to Supplier portal with Emailid as "qatech@gmail.com"
    When I enter the password as "qatech@123"
    And I click Admin Login button
    Then I validate error message
  
    
