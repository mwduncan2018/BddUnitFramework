@Browser
Feature: Demo feature

  @GridDemo
  Scenario Outline: Maryland SmartAsset paycheck calculator, semi-monthly
    Given I navigate to the SmartAsset paycheck calculator for Maryland
    When I have a salary of <baseSalary>
    Then verify the semi-monthly take home pay is <semiMonthly>

    Examples:
      | baseSalary | semiMonthly |
      | 100000     | 2812        |
      | 150000     | 4083        |
      | 200000     | 5341        |
      | 250000     | 6478        |
      | 300000     | 7597        |
      | 350000     | 8716        |
      | 400000     | 9835        |

  @GridDemo
  Scenario Outline: Florida SmartAsset paycheck calculator, semi-monthly
    Given I navigate to the SmartAsset paycheck calculator for Florida
    When I have a salary of <baseSalary>
    Then verify the semi-monthly take home pay is <semiMonthly>

    Examples:
      | baseSalary | semiMonthly |
      | 100000     | 3133        |
      | 150000     | 4588        |
      | 200000     | 6032        |
      | 250000     | 7351        |
      | 300000     | 8656        |
      | 350000     | 9961        |
      | 400000     | 11267       |



  #Scenario: Demo browser scenario
    #Given I do a thing
    #When I do another thing
    #Then I verify the thing

  #@Debug
  #Scenario: Demo browser Java 8 scenario
    #Given I do something
    #When I do something else
    #Then I verify something
