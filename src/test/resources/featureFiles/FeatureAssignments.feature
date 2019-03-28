#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Goals and Assignments
  
  Background:
  Given I login launch site "http://www.seleniumframework.com/Practiceform/"

  Scenario: Assignment3
    When I navigate to Home Page
    Then I navigate backward
    Then Display title of link 'This is a link'
    Then I enter email address
    Then I enter valid details in Contact Us form

    Scenario: Assignment4
    Then I count total input boxes available on form
    Then I get the color code
    Then I perform button operations
    Then I perform links operations
    Then I click Element8
