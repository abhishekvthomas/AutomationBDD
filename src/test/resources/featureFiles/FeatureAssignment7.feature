Feature: Goals and Assignments7

  Scenario: Assignment7
    Given I login launch site "http://adam.goucher.ca/parkcalc/"
    When I choose a lot
    When I choose entry date and time
    When I choose exit date and time
    Then I calculate
    Then I close browser

    Scenario: Assignment7 Part2
    Given I login launch site "http://automationpractice.com/index.php"
    Then verify less than 10 products displayed on home page
    Then verify 3 items displayed on Dressed
    Then Filter records of color "color-white" and verify
    And clear filter
    Then set price range and verify results
    
    Scenario: Assignment7 Part3
    Given I login launch site "http://automationpractice.com/index.php"
    When I launch dresses in summer dresses in list view
    Then I launch quick view of first item
    And I add to wishlist
    Then I verify warning message
     
    Scenario: Assignment7 Part4
    Given I login launch site "http://automationpractice.com/index.php"
    When I search for keyword Printed Dress
    And I add third item to cart
    Then I verify if the correct item is added to cart
    And I checkout items
    Then I verify user launched on Authentication Page
    