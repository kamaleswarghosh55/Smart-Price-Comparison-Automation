**Smart Price Comparison Automation**

This project is a Selenium-based automation framework that compares the price of a product across three e-commerce websites: Amazon, Flipkart, and Croma.
The script searches for a product, extracts the price from each site, compares the values, and generates an Excel report with the results.

**1. Project Overview
**
The goal of this project is to demonstrate how automation can be applied to a practical scenario like price comparison.
The framework is designed using the Page Object Model (POM) to ensure clean structure, maintainability, and scalability.

**Key actions performed:
**
Open each website

Search for a product

Extract the displayed price

Compare prices

Write the results to an Excel file

**2. Key Features
**
Live price extraction from three real e-commerce platforms

Selenium WebDriver automation with dynamic waits

Clean Page Object Model (POM) design

Modular test structure using TestNG

Excel reporting using Apache POI

Easily extendable to additional websites

**3. Tech Stack
**
Java

Selenium WebDriver

TestNG

Maven

Apache POI (Excel)

IntelliJ IDEA

Git & GitHub

**4. Project Structure
**src/
 ├─ main/
 │   └─ java/
 │        ├─ pages/        → Page classes for Amazon, Flipkart, Croma
 │        └─ utils/        → DriverFactory and ExcelWriter
 │
 └─ test/
      └─ java/
           └─ tests/       → BaseTest and PriceComparisonTest

pom.xml
testng.xml
README.md

**5. How to Run the Project
**Step 1: Clone the repository
git clone https://github.com/kamaleswarghosh55/Smart-Price-Comparison-Automation.git

Step 2: Install dependencies
mvn clean install

Step 3: Run the test suite

Option A: Right-click testng.xml → Run
Option B:

mvn test

**6. Output Report
**
After execution, an Excel file is created:

PriceComparisonReport.xlsx


The report includes:

Product name

Price from Amazon

Price from Flipkart

Price from Croma

Lowest price

**7. Framework Components
**pages/

Contains page classes for each website.
Each class includes methods for searching and extracting prices.

utils/

DriverFactory: Handles WebDriver setup and teardown

ExcelWriter: Writes extracted values to Excel

tests/

BaseTest: Initializes and closes the browser

PriceComparisonTest: Contains the complete comparison workflow

**8. Future Enhancements
**
Add HTML reporting (Allure or Extent Reports)

Add logging and screenshots

Add support for more e-commerce websites

Include CI/CD pipeline using GitHub Actions

Add parallel test execution

**9. Author
**
Kamaleswar Ghosh
Email: kamaleswarghosh55@gmail.com

GitHub: https://github.com/kamaleswarghosh55

LinkedIn: https://linkedin.com/in/kamaleswarghosh55
