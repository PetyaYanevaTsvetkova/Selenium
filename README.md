## Project's Title:
	Selenium Web Driver

## Project Description:
	Theory:

	What is POM (Page Object Model)
	Web driver (Local/Remote)
	Locators in Selenium
	XPath
	Difference between driver.close and driver.quit
	Waits
	What is Headless testing
	JavascriptExecutor
	Actions
	Expected Conditions

	Practical Tasks:

	Setup Selenium with Docker:
	https://www.browserstack.com/guide/run-selenium-tests-in-docker 
	Download Standalone jar and Selenium web driver 
	Download both files in the same directory
	For creating UI instance of Browser - open command
	prompt in the file directory and execute the following script 
	“java -jar selenium-server-4.3.0.jar standalone --port 4545”

	Download jar file from:
	https://www.selenium.dev/downloads/ 
	https://chromedriver.chromium.org/downloads 

	Write tests with Cucumber and Selenium: 

	Registration: Create a registration (create one account only for test purposes,  do not make positive scenarios because we will spam the site with fake data)

	Login:
		Positive scenarios: 
			Correct username and password for login functionality 
		Negative scenarios: 
			Login without username;
			Log in without a password;
			Empty login;
			Login with an incorrect username and password

	Add Table to Cart and assert that it is added successfully
		Increase the product quantity in the Cart 
		Assert the price is calculated correctly
	Add Chair to Cart and assert that it is added successfully
 		Increase the product quantity in the Cart 
		Assert the price is calculated correctly



## Table of Contents:
	estafetShopizer
	README.md file
	.gitignore file
	

## How to Install and Run the Project:
	IDE need to execute the java project
	 
## How to Use the Project:
	Maven need

## Useful links:
	https://www.selenium.dev/documentation

## Add a License
	no needed


