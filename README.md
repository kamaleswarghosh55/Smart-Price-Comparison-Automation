---

# **Smart Price Comparison Automation**

*A practical Selenium automation framework built to compare live product prices across e-commerce websites.*

---

## ** Project Overview**

This project automates the process of checking and comparing the price of a product across:

* **Amazon**
* **Flipkart**
* **Croma**

The framework searches for a product, extracts its price, compares the values, and generates an **Excel report** showing the final results.

---

## ** Key Highlights**

* **Live website automation** (no mock or practice sites)
* **Extracts real-time product prices** using reliable locators
* **Compares pricing data** across multiple websites
* **Outputs clean Excel reports** with pricing information
* **Designed using POM (Page Object Model)** for easy maintenance
* **Readable, modular, and scalable test structure**

---

## ** Tech Stack & Tools**

* **Language:** Java
* **Automation:** Selenium WebDriver
* **Testing Framework:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **Build Tool:** Maven
* **Reporting:** Apache POI (Excel)
* **Version Control:** Git & GitHub
* **IDE:** IntelliJ IDEA

---

## ** Project Structure**

```
src/
 ├─ main/
 │   └─ java/
 │        ├─ pages/        → Page classes for each website
 │        └─ utils/        → DriverFactory, ExcelWriter
 │
 └─ test/
      └─ java/
           └─ tests/       → BaseTest + PriceComparisonTest

pom.xml
testng.xml
README.md
```

---

## ** What This Project Demonstrates**

* Ability to **design a clean automation framework**
* Strong understanding of **locators, waits, and dynamic elements**
* Experience working with **real production websites**
* Good structure using **POM + utilities + TestNG**
* Knowledge of **data extraction + reporting**
* Practical thinking by automating a real use case

This is exactly the type of project product companies like to see in a fresher's profile.

---

## ** How to Run the Project**

### **1. Clone the repository**

```bash
git clone https://github.com/kamaleswarghosh55/Smart-Price-Comparison-Automation.git
```

### **2. Install dependencies**

```bash
mvn clean install
```

### **3. Run the test suite**

* Run `testng.xml` from IntelliJ
  **or**

```bash
mvn test
```

---

## ** Excel Report Output**

After the test completes, an Excel file is generated:

```
PriceComparisonReport.xlsx
```

It includes:

* Price from Amazon
* Price from Flipkart
* Price from Croma
* Lowest available price

---

## ** Framework Components (Short Explanation)**

### ** pages/**

Contains all website-specific actions

* `AmazonPage.java`
* `FlipkartPage.java`
* `CromaPage.java`

Each class handles:

* Searching the product
* Extracting the price

---

### ** utils/**

Reusable helper classes

* `DriverFactory.java` → WebDriver setup and teardown
* `ExcelWriter.java` → Writes results into Excel

---

### ** tests/**

Full test flow

* `BaseTest.java` → Parent class for tests
* `PriceComparisonTest.java` → Main comparison logic

---

## ** Future Enhancements**

* Add HTML reporting (Allure or Extent)
* Add failure screenshots
* Parallel execution using TestNG
* Integrate GitHub Actions (CI pipeline)
* Extend to Reliance Digital / TataCliq / Vijay Sales
* Add product list (read from Excel or JSON)

---

## ** Author**

**Kamaleswar Ghosh**

* GitHub: [https://github.com/kamaleswarghosh55](https://github.com/kamaleswarghosh55)
* LinkedIn: [https://linkedin.com/in/kamaleswarghosh55](https://linkedin.com/in/kamaleswarghosh55)
* Email: *[kamaleswarghosh55@gmail.com](mailto:kamaleswarghosh55@gmail.com)*

---

##  **Support the Project**

If you find this project useful, please consider giving it a **star** on GitHub.
It helps others discover it and motivates further improvements.

---
