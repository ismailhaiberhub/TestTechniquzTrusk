Feature: The user verify the access to the website of Trusk

  Scenario Outline:The user search for the trusk website via Google search
    Given the user on the google page "<GoogleUrl>"
    And the user verify that the search bar is empty
    Then the user fill the search bar with the word 'Trusk'
    When the user hits the button
    Then the first result must contain this keywords "<Keywords>"
    When the user click on the first result
    Then the user must verify that he is redirected to this link "<TruskLink>"
    Examples:
      |GoogleUrl             | Keywords                       | TruskLink|
      |https://www.google.com| Trusk livre tout, tout de suite| https://trusk.com/fr/ |


    @Smoke
    Scenario Outline: The user verfiy the links of Trusk Website
      Given the user on the google page "<GoogleUrl>"
      And the user verify that the search bar is empty
      Then the user fill the search bar with the word 'Trusk'
      When the user hits the button
      Then the first result must contain this keywords "<Keywords>"
      When the user click on the first result
      Then the user must verify that he is redirected to this link "<TruskLink>"
      When the user click on "<Elements>"
      Then the user is redirected to right link "<AddedLink>"
      Examples:
        |GoogleUrl             | Keywords                       | TruskLink             |Elements        |AddedLink|
        |https://www.google.com| Trusk livre tout, tout de suite| https://trusk.com/fr/ |Devenir Trusker |truskers|
        |https://www.google.com| Trusk livre tout, tout de suite| https://trusk.com/fr/ |Trusk Business  |business|

