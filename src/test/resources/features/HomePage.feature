Feature: Home Page

  Scenario: Verify Apple Page Title
    Given I open the "https://www.apple.com" page
    Then the title should be "Apple"

  Scenario: Verify Google Page Title
    Given I open the "https://www.google.com" page
    Then the title should be "Google"

  Scenario: Verify Tesla Page Title
    Given I open the "https://www.tesla.com" page
    Then the title should be "Tesla"

  Scenario: Verify Adobe Page Title
    Given I open the "https://www.adobe.com" page
    Then the title should be "Adobe"