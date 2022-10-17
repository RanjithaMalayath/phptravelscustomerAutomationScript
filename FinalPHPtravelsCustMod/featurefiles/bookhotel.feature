@tag
Feature: Book Hotel
  As a customer I should be able to filter hotel booking
  options and book a hotel
   @bookhotel
   Scenario Outline: Check customer able to book hotel of their choice
    Given I login to customer portal with Emailid as "qatech@gmail.com"
    When I enter password as "qatech@123"
    And I click Login button
    And I click Hotels tab
    And select "<City>" from the dropdown
    And select "<Checkin>" date from the checkin date picker
    And select "<Checkout>" date from the checkout date picker
    And add room count "<Roomcount>"
    And add adults count "<Adultcount>"
    And add child count "<Childcount>"
    And select child age "<Childage>"
    And select nation "<Nation>"
    And click on search icon
    And click on Details button of the hotel to view more details
    And click Book Now button against the preffered room type
    And Fill Travellers Information
    And select Payment Method
    And click T&C checkbox
    And click Confirm Booking
    When I click My Bookings
    And I click on View Voucher
    Then validate booking details
    When I click Logout
    Then I should see Customer Login page
    Examples: 
      | City       |    Checkin       | Checkout        | Roomcount | Adultcount |Childcount|Childage |Nation|
      | singapore  |8-December 2022 | 17-December 2022|    3      |  3         |    1     |4        |India |                        					           