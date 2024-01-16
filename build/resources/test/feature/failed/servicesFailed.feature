@cucumber
Feature: Execute Services
  @1
  Scenario Template: Execute services Failed
    Given data Obtener TC
    When services Failed
    Then  response
    Examples:
      |Sprint|
      |1    |
      |2    |