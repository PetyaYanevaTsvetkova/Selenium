@LoginPageTests
Feature: Login with positive and negative tests

  Background:
  Given Navigate to Login Page

  @PositiveLogin
  Scenario: Positive Login Test
    Given Username estafettest@gmail.com and Password Est@fetTest123
    When Try to Login
    Then Assert you are Logged in successfully and you are redirect to http://localhost/my-account url

  @NegativeLogin
  Scenario Outline: Negative Login Tests
    Given Username <username> and Password <password>
    When Try to Login
    Then Assert you are NOT Logged in successfully and you are still in http://localhost/login url
    Examples:
      | username              | password          |
      |                       | Est@fetTest123    |
      | estafettest@gmail.com |                   |
      |                       |                   |
      | incorrectUsername     | incorrectPassword |