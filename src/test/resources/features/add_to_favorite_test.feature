# language: en

@all
Feature: Adding ads to the favorites tab

  @singleAd
  Scenario: Add a single ad to your favorites

    Given opened home page of ad site
    When go to the "Техника" category
    And select the "Наушники" section
    And select 1 product from the list in the section
    Then the 'Favorites' tab shows 0 added products
    When scroll to add favorites button
    Then the add to favorites button is named "Добавить в избранное"
    When click on the add to favorites button
    Then the add to favorites button is named "Удалить из избранного"
    When scroll to the 'Favorites' tab
    Then the 'Favorites' tab shows 1 added products
    When click on the 'Favorites' tab
    Then the favorites table with 1 entries is displayed

  @multipleAds
  Scenario: Add multiple ads to your favorites

    Given opened home page of ad site
    When go to the "Техника" category
    And select the "Усилители" section
    And select 1 product from the list in the section
    And scroll to add favorites button
    And click on the add to favorites button
    And go back to the previous page
    And select 2 product from the list in the section
    And scroll to add favorites button
    And click on the add to favorites button
    And scroll to the 'Favorites' tab
    Then the 'Favorites' tab shows 2 added products
    When click on the 'Favorites' tab
    Then the favorites table with 2 entries is displayed

  @deleteAd
  Scenario: Delete an entry from your favorites

    Given opened home page of ad site
    When go to the "Техника" category
    And select the "Колонки" section
    And select 1 product from the list in the section
    And scroll to add favorites button
    And click on the add to favorites button
    And scroll to the 'Favorites' tab
    And click on the 'Favorites' tab
    Then the favorites table with 1 entries is displayed
    When click on the button to clear the favorites list
    Then the favorites table with 0 entries is displayed

  @searchAd
  Scenario: Add an ad found via search to your favorites

    Given opened home page of ad site
    When enter "Ботинки" in the search bar and press Enter
    And select 1 product from the list in the section
    Then the 'Favorites' tab shows 0 added products
    When scroll to add favorites button
    And click on the add to favorites button
    And scroll to the 'Favorites' tab
    Then the 'Favorites' tab shows 1 added products
    When click on the 'Favorites' tab
    Then the favorites table with 1 entries is displayed