@foo
Feature: Convert Integer to Roman Numerals

  Scenario: Convert Integer to Roman Numerals

    When I give 8
    Then I get the roman numeral VIII
