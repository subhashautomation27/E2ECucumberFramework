Feature: Login functionality

Scenario: user login with valid credentials
Given user navigates to the login page
When user has entered the email address "subash1@gmail.com" into email field
And user has entered the password "1234567" into password field
And user has clicks the login  button
Then user should get succesfully logged in

Scenario: user login with valid email and invalid password 
Given user navigates to the login page 
When user has entered the email address "subash1@gmail.com" into email field
And user has entered the invalid  password "123" into password field  
And user has clicks the login  button
Then user should get warnning messages about No match for E-Mail Address and/or Password

Scenario: user login with invalid email address and valid password 
Given user navigates to the login page 
When user has entered the invalid  email address into email field
And user has entered the password "1234567" into password field  
And user has clicks the login  button
Then user should get warnning messages about No match for E-Mail Address and/or Password

Scenario: user login with invalid email address and invalid password 
Given user navigates to the login page 
When user has entered the invalid  email address into email field
And user has entered the invalid  password "123" into password field  
And user has clicks the login  button
Then user should get warnning messages about No match for E-Mail Address and/or Password 

Scenario: user without providing any credentials 
Given user navigates to the login page 
When user has not entered email addres into email field
And user has not entered the password into password field  
And user has clicks the login  button
Then user should get warnning messages about No match for E-Mail Address and/or Password 

