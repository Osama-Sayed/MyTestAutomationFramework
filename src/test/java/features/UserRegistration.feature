Feature: User Registration
  I want to check that the user can register in our ecommerce website

  Scenario Outline: User Registration
    Given the user in the home page
    When I click on register link
    And I entered "<firstname>", "<lastname>", "<email>", "<password>"
    Then The registration page displayed successfully

    Examples:
    | firstname | lastname | email| password |
    | osama | sayed |osamatest1@test.com |123456 |
    | Ahmed | Medhat | ah1@test.com | 1234568 |
