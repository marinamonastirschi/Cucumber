Feature: Adding new jobs in HRMS

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application

    @addJob
    Scenario: User adds a new job
      * user clicks on the admin button
      * user clicks on the job button
      * user clicks on Job Titles
      * user clicks on the add button
      * user enters job "NoOne" title
      * user enters job description "Teaches nothing"
      * user enters job note "None"
      * user clicks on the save button
      * verify data is stored properly in database
