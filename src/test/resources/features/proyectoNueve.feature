#Author: Valeria Rivera

Feature:Make a query for banks in the Yellow Pages Web and verify the list of the first 10 banks
  that the web page is as expected

  @Tag1
 Scenario Outline: Banks
    Given  I want to consult in the search fields
      | banks | city |
      |<banks>|<city>|
    When  The information of these is displayed
    Then I verify that the link on the website leads to the corresponding bank
    Examples:
      |banks |city    |
      |Bancos|Medellin|


