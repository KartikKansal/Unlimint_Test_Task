Feature: User Registration

  Scenario Outline: User will be registered in portal
    Given User Opens Page
    And User Clicks Register Link
    When User Fill Register Form
    Then User Registers Successfully

    Scenario Outline: User Tranfers Money
      Given User Click BillPay
      When User Fills Pay Transfer Details
      Then Amount Tranfers Successfully

      Scenario Outline: Close Browser
        Given Browser Close

