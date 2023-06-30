Feature: As a data consumer, I want the department information stored in postgress DB correct
Background:
  Given Establish teh database connection

@db
  Scenario: verify database departments table columns

    When Execute query to get all columns for "departments"
    Then verify the below column sare listed in result for

      | tax                  |
      | bookkeeping           |
      | payroll              |
      | consultancy-services |