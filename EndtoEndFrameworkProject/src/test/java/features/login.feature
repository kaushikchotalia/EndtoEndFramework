Feature: Login into application 

Scenario: Positive login test
Given Initialize browser with chrome browser 
And Navigate to "http://www.qaclickacademy.com/" site
And Click on log link in home page to land on secure log in page
When User enters "test99@gmail.com" and "123456" and Logs In 
Then Verify that user is successfully Logged In 