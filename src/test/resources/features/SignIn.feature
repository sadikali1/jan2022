@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @Smoke @Regression 
  Scenario: Verify user login successfully
    Given I navigated url on browser
    When I enter user name into user input field
    And I enter password in password filed
    And I click on login button
    Then I verify user login successfully

  @Regression
  Scenario: Verify invalid user login
    Given I navigated url on chrome browser
    When I enter user name into user input field
    And I enter password in password filed
    And I click on login button
    Then I verified user not login successfully