# test automation exercise Framework 🚀

This project implements a **Cucumber BDD** test automation framework using **Selenium WebDriver for UI testing** and **RestAssured for API testing**. The framework is built with **Java, Maven, Cucumber, TestNG, and JUnit** and supports **cross-browser execution **.

---

## 📌 Features
- 📝 **Cucumber BDD** for structured and readable tests.
- 🌐 **Selenium WebDriver** for browser automation.
- 🔗 **RestAssured** for API testing.
- 🎭 **Page Object Model (POM)** for maintainable UI tests.
- 🚀 **WebDriverManager** for automatic driver handling.
- 🏷️ **Tagged test execution** to run specific scenarios
---

## ⚙️ Setup Instructions

### 📥 Clone the Repository

git clone https://github.com/qatestifs/test-automation-exercise.git
cd test-automation-exercise

### 📌 Install Dependencies

mvn clean install

---

## 🚀 Running Tests

### 🔹 Run All Tests
mvn test

---
### 🔹 Run Tests Using Tags
To execute specific tests based on tags:
mvn test -Dcucumber.filter.tags="@sanity"

---
### 🔹 **Cucumber Reports**
Maven automatically generates a Cucumber HTML report at:  
📂 `target/cucumber-reports.html`
    `target/testng-reports.html`

---