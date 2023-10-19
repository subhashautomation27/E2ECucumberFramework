

 Feature: Search Functionality

Scenario: user searches the valid product
Given user navigates the homepage
When user has entered the product "HP" into search field 
And user clicks on search button
Then user should get valid product information successfuly  

Scenario: user searches the invalid product
Given user navigates the homepage
When user has entered the invalid product "BIke" into search field 
And user clicks on search button
Then user should get warring message about There is no product that matches the search criteria  

Scenario: user searche without enter product name
Given user navigates the homepage
When user not  entered the product into search field 
And user clicks on search button
Then user should get warring message about There is no product that matches the search criteria 