Feature: Bonus Policy
  The bank follows a bonus policy, depending on the customer type and on the credits

  Scenario Outline: Usual customer bonus policy
    Given we have a usual customer with credit offers
    When the usual customer has credit offers with amounts <amount1> and <amount2> and <amount3>
    Then the bonus points of the usual customer should be <points>

    Examples:
      | amount1 | amount2 | amount3| points |
      |     349 |     319 |    623 |     64 |
      |     312 |     356 |    135 |     40 |
      |     223 |     786 |    503 |     75 |
      |     482 |      98 |    591 |     58 |
      |     128 |     176 |    304 |     30 |

  Scenario Outline: VIP customer bonus policy
    Given we have a VIP customer with credit offers
    When the VIP customer has credit offers with amounts <amount1> and <amount2> and <amount3>
    Then the bonus points of the VIP customer should be <points>

    Examples:
      | amount1 | amount2 | amount3| points  |
      |     349 |     319 |    623 |     129 |
      |     312 |     356 |    135 |      80 |
      |     223 |     786 |    503 |     151 |
      |     482 |      98 |    591 |     117 |
      |     128 |     176 |    304 |      60 |