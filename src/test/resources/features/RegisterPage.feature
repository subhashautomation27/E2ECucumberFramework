Feature: Registerpage functionality 

Scenario: user creates the account with mandatory fileds
Given user navigates the register page 
When user has enters the below details into fileds 
| firstName 		  |subash  |
|lastName 				|chandraBose|
|telephone        |1234567890|
|password					|1234567|
|confirm_password |1234567|
And user select the privacy policy
And user clicks on continue button
Then user account should get created succesfully  


Scenario: user creates the acoount with all feilds
Given user navigates the register page 
When user has enters the below details into fileds 
| firstName 		  |subash  |
|lastName 				|chandraBose|
|telephone        |1234567890|
|password					|1234567|
|confirm_password |1234567|
And user select the yes for Newletter
And user select the privacy policy
And user clicks on continue button
Then user account should get created succesfully  

Scenario: user creates dupilicate account
Given user navigates the register page 
When user has enters the details into below fileds with dupilicate email 
| firstName 		  |subash  |
|lastName 				|chandraBose|
|email            |subash2@gmail.com|
|telephone        |1234567890|
|password					|123456|
|confirm_password |123456|
And user select the privacy policy
And user clicks on continue button
Then user should get proper warning message about dupilicate email  


Scenario: user craetes the account without filling any fields
Given user navigates the register page 
When user dont enters the any details into fileds 
And user clicks on continue button
Then user should get proper warning message about every mandatory fileds   













 
