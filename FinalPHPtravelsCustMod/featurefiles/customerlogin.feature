
@tag
Feature: Customer Login
  As a valid customer 
  I want to login to the application
  and manage my profile

  @login_valid_creds
  Scenario: Check Customer Login with valid credentials
    Given I login to customer portal with Emailid as "qatech@gmail.com"
    When I enter password as "qatech@123"
    And I click Login button
    Then I should see customer name 
    When I click My Profile
    Then validate First Name and customer name present in the dashboard are same
    When I click Logout
    Then I should see Customer Login page
    

  @login_invalid_creds
  Scenario Outline: Check Customer Login with Invalid credentials
    Given I login to customer portal with Emailid as "<Email>"
    When I enter password as "<Password>"
    And I click Login button
    Then I validate the error message displayed

    Examples: 
      | Email                         |     Password      |
      | qatech@gmail.com             |        abc        |
      | testabc@gmail.com						  |     qatech@123  | 
      | testdemo@gmail.com						|     Demo@123      | 
      |                   					  |                   | 