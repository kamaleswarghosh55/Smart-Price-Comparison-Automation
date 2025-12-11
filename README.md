Smart Price Comparison Automation

A small automation framework built using Selenium, Java, TestNG, and POM, designed to compare live product prices across Amazon, Flipkart, and Croma.
The script searches for a product, extracts the prices from each website, compares them, and saves the results in an Excel report.

What the Project Does

Opens all three e-commerce sites

Searches for the same product

Extracts live prices using stable locators

Compares the values

Generates an Excel file with the results

Highlights the lowest price

Tech Stack

Java 17

Selenium WebDriver

TestNG

Apache POI (Excel)

Maven

Page Object Model (POM)

Why This Project Is Useful

Demonstrates real-world automation (not dummy websites)

Shows ability to design a clean, modular test framework

Covers dynamic waits, locator strategies, and data handling

Built to be extendable for more websites or test cases

Good example of applying automation to solve a practical problem

How to Run
mvn clean install
mvn test


or simply run the testng.xml file from IntelliJ.

Output

Generates an Excel file:

PriceComparisonReport.xlsx


Contains:

Amazon price

Flipkart price

Croma price

Lowest price

Future Improvements

Allure / Extent reporting

Support for more e-commerce sites

CI/CD pipeline

Parallel execution

Author

Kamaleswar Ghosh
GitHub: https://github.com/kamaleswarghosh55

LinkedIn: https://linkedin.com/in/kamaleswarghosh55
