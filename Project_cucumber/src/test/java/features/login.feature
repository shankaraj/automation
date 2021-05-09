#@tag
Feature: Login into QA click academy Application
	#@tag1
  Scenario Outline: Positive login functionality 
    Given Initialize the browser with chrome
    And Navigate to "http://qaclickacademy.com/" site
    And Click on Login link in homepage to land on sign in page with <username> and <password>
		Then verify that user is successfully logged in
		And close browsers

Examples:
	|username|password|
	|test99@gmail.com|123456|
	|test100@gmail.com|123|
	|umashankarr@gmail.com|AA|
	