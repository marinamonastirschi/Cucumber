Feature: Login related scenarios

  Background:
    #Given user is navigated to HRMS application

  @smoke @regression @smoke @newTestcase @newFeature @sprint1 @login1
  Scenario: Valid admin login
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application

  @employee @sprint1 @login1
  Scenario: valid ess login
    When user enters ess username and password
    And user clicks on login button
    Then user is successfully logged in the application

  @invalid @sprint1
  Scenario: invalid admin login
    When user enters invalid admin username and password
    And user clicks on login button
    Then error message is displayed

  @negative
  Scenario Outline: negative login test
    When user enters "<username>" and "<password>" and verifying the "<error>" for the combinations
    Examples:
      | username | password    | error                    |
      | admin    | dgfgfg      | Invalid credentials      |
      | dfvfdgr  | Hum@nhrm123 | Invalid credentials      |
      |          | Hum@nhrm123 | Username cannot be empty |
      | admin    |             | Password cannot be empty |

