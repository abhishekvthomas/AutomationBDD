Feature: Goals and Assignments5

  Scenario: Assignment5
    #Given I login launch site "https://www.toolsqa.com/automation-practice-form/"
    #When I enter information details
    And I login launch site "http://money.rediff.com/losers/bse/daily"
    Then I get details of 10 gainers from Daily section
    Then I get details of 10 losers from Weekly section
