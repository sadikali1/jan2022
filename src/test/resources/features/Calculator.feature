@tag
Feature: Calculator

  Background: executed before scenario
    Given I am background scenario

  @Smoke @Regression @Test1
  Scenario: Add two number
    Given Two integer number 10 and 20
    When I added both interger number
    Then result is equals to 30

  @Regression
  Scenario Outline: Add two number
    Given Two integer number <firstNumber> and <secondNumber>
    When I added both interger number
    Then result is equals to <result>

    Examples: 
      | firstNumber | secondNumber | result |
      |          10 |           20 |     30 |
      |          11 |           12 |     24 |
      |           8 |           20 |     28 |
