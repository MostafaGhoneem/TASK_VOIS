# TASK_VOIS


## Description 
### Main
* ### helpers 
 * Constant: is a class to store constant values we will use in our framework
 * ExcelReader: is a class to read from excel file 
 * GUIActions: is a class to store actions as a methods to use in our Pages
 * PropertiesReader: is a class to read from property file 
 * WebDriverFactory: is a class to initiate our drivers like Chrome,Firefox and Edge
 * SeleniumListener & TestngListener: is a classes to listen and log the info into the loggers and reports
 
* ### utilities 
 * ExcelManager: to manage to set the file name and sheet name and load the excel sheet
 * Mylogger: to set the methods of our logs 
 * PropertiesManager: to load the propertyfiles

* ### Pages
 *HomePage: to define HomePage Elements and initialize the methods we will perform in this Page
 *SearchPage: to define SearchPage Elements and initialize the methods we will perform in this Page
 
 
### Test 
* ### Base
 * BaseTest : this is the parent class that the child classes will inherit the methods Like what will happen before and after each class and method like setup the driver and   initialize the url
* ### data_provider
 *DataProvider : this return the date in a specific excel in a specific sheet and provide it to the test when we call it
* ### tests
 *SearchTest : here we do our Tests and assert the results
 

## prerequests
* JDK 17
* Maven
* Allure if You want to generate the report please open the terminal in Intellij and type (allure serve)
