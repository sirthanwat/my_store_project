# "MyStore Project(E-commerce Application)" 

## Created framework using BDD and Page object model

## Tool / Technologies used :
```
* Eclipse IDE for Enterprise Java Developers 2019-06 (4.12.0)
* JAVA Jdk 1.8.0_251 
* selenium-java 3.141.59 
* cucumber-junit 6.2.2
* cucumber-java 6.2.2
```

For other maven dependency please Refer pom.xml file.

## Flow of the Work assignment
```
* Launch the My Store app.
* Scenario 1 : Search a product and validate that the search result is the correct product being displayed
* Scenario 2 : Scroll down from the home page and add a product to cart and validate the addition of the product is successful to the cart.
* Scenario 3 : Scroll down to a product to a mouse over and click on More, validate the  resulting page has correct information and also the functionality in that page is working by validating increment and decrement of quantity, size and then Add to Cart
* Scenario 4 : Create a login page failure validation
```

## How To Verify the changes (Running Test Cases): 

```
First Way:
* Go to  src\test\java\com.web.automation.runner\TestRunner.java
* Inside file right click --->Run (Eclipse IDE functionality)

```

## Important Variables & terminology need to follow

```
* Root directory for features file location : .\featureFiles
* Root directory browser driver location : .\driver
* All the required project Configuration details location : .\configFile\projectConfiguration.properties
* All the elements test data details location : .\elementLocators\locators.properties
* Page methods and xpath locator location : .\src\test\java\com\web\automation\pages
* Utilities class => Contains all Common functions and project configuration class :
  PATH: \src\main\java\utilities\CommonFuntions.java 
        \src\main\java\utilities\ConfigReader.java
  
* Assertion package => compare class => Assertions & Validations 
```

   
