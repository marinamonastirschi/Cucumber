Feature: Adding employee in HRMS application

  Background:
    When user enters valid admin username and password
    When user clicks on login button
    And user is successfully logged in the application
    And user clicks on PIM option
    And user clicks on add employee button

  @test
  Scenario: adding one employee
    When user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @sample
  Scenario: employee added successfully
    When user enters "adam" and "lovely" and "farwa"
    And user clicks on save button
    Then employee added successfully

  @outline
  Scenario Outline: adding multiple employees using scenario outline
    When user enters "<firstName>" and "<middleName>" and "<lastName>" in data driven format
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      | leny      | darzi      | fraud    |
      | paster    | surma      | shalli   |
      | sana      | caty       | aim      |
@datatable
  Scenario: adding multiple employees using data table
    When user enters firstname and middlename and verify employee has been added
      | firstname | middlename | lastname |
      | zara      | ms         | zaca     |
      | mary      | ms         | django   |
      | sadam     | ms         | adam     |

  @excel
Scenario: adding multiple employees using excel file
  When user enters enters multiple employees using excel from "EmployeeDataBatch16" and verify it

  @Db
  Scenario: employee added successfully
    When user enters "adam" and "lovely" and "farwa"
    And user clicks on save button
    Then employee added successfully
    Then verify employee is stored in database