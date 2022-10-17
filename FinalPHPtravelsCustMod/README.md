Page Object Model (POM) in Selenium with Cucumber TestNG and Maven.

POM - Created Object repository for web elements in the UI using the pattern POM.

Created a Maven project and added all libraries required for the project in pom.xml file as dependencies.
In this project, scenarios are written in Gherkin syntax and added in "featurefiles" folder for each module with an extension ".feature".

A POM class file has been created for each web page to store the element locators (Ex: CustomerLoginPOM.java,etc,.) and saved in the package "pageobjects"
Step definitions for each feature files are added under the package "stepdefinitions" and all the methods used for throughout the project is defined in the class created under this package.

All the testcases are saved in the package "testrunners".
Testcases are run as TestNG and results can be viewed in "reports/*". Used Extents Report to generate test results.



