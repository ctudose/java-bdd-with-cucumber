Feature: Customers Policy
  The bank follows a policy of adding and removing customers to offers

  Scenario: Economy credit offer, usual customer
    Given there is an economy credit offer
    When we have a usual customer
    Then you can add and remove him from an economy credit offer
    And you cannot add a usual customer to a credit offer more than once

  Scenario: Economy credit offer, VIP customer
    Given there is an economy credit offer
    When we have a VIP customer
    Then you can add him but cannot remove him from an economy credit offer
    And you cannot add a VIP customer to a credit offer more than once

  Scenario: Business credit offer, usual customer
    Given there is an business credit offer
    When we have a usual customer
    Then you cannot add or remove him from a business credit offer

  Scenario: Business credit offer, VIP customer
    Given there is an business credit offer
    When we have a VIP customer
    Then you can add him but cannot remove him from a business credit offer
    And you cannot add a VIP customer to a credit offer more than once

  Scenario: Premium credit offer, usual customer
    Given there is an premium credit offer
    When we have a usual customer
    Then you cannot add or remove him from a premium credit offer

  Scenario: Premium credit offer, VIP customer
    Given there is an premium credit offer
    When we have a VIP customer
    Then Then you can add and remove him from a premium credit offer
    And you cannot add a VIP customer to a credit offer more than once