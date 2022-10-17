
@tag
Feature: Check Customer Profile Management
  As a valid customer
  I should be able to access and manage my profile
  So that my details will be upto date

  @tag1
  Scenario: Check whether valid customer can manage their profile
    Given I login to customer portal with Emailid as "qatech@gmail.com"
    When I enter password as "qatech@123"
    And I click Login button
    When I click My Profile
    And I edit my First Name as "Ranjithaa"
    And I edit my Last Name as "Malayath"
    And I edit my Phone as "8891369207"
    And I enter my State as "Kerala"
    And I enter my city as "Kochi"
    And I enter my Fax as "8987678987"
    And I enter my Postal code as "676551"
    And I enter my address as "Malayath House"
    And I click Update Profile button
    Then I validate profile updated success message as "Profile updated successfully."
     When I click Logout
    Then I should see Customer Login page
 
