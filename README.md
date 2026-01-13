🥷 NinjaV7 – Selenium Hybrid Automation Framework

Enterprise-Grade UI Automation Framework for CloudBerry Store (OpenCart)

NinjaV7 is a scalable, maintainable, and high-performance Selenium Hybrid Automation Framework built using Java + Selenium WebDriver 4 + TestNG, following real-world industry standards.
This framework is designed without BDD/Cucumber, focusing on clean architecture, reusability, and execution efficiency.

🚀 Key Highlights

Enterprise-ready Hybrid Framework

Page Object Model (POM) design

Centralized WebDriver management

TestNG-based execution (Groups, Parallel runs)

Extent HTML reporting

Screenshot capture on failure

Retry mechanism for flaky tests

Multi-browser support

CI/CD friendly (Jenkins-ready)

🧰 Tech Stack
Component	Technology
Language	Java
Automation Tool	Selenium WebDriver 4
Test Framework	TestNG
Build Tool	Maven
Design Pattern	Page Object Model (POM)
Reporting	Extent Reports
Logging	Log4j
CI	Jenkins Compatible
Browsers	Chrome, Firefox, Edge

🧱 Framework Architecture
NinjaV7
├── src/test/java
│   ├── pageObjects        # Page Object Model classes
│   ├── testCases          # TestNG test classes
│   ├── testBase           # BaseClass (WebDriver setup)
│   ├── utilities          # Utilities (config, waits, screenshots)
│   └── listeners          # TestNG listeners (Extent, retry)
│
├── src/test/resources
│   ├── config.properties  # Environment & credentials
│   └── testdata           # Test data files (Excel / JSON)
│
├── test-output            # TestNG reports
├── screenshots            # Failure screenshots
├── testng.xml             # Suite configuration
├── pom.xml                # Maven dependencies
└── README.md

🌐 Application Under Test

CloudBerry Store (OpenCart)
🔗 https://www.cloudberrystore.services

📘 Sample Test Case (Hybrid – TestNG)
@Test(groups = {"sanity","regression"})
public void verifyLogin() {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);

    home.clickMyAccount();
    home.goToLogin();

    login.setEmail(prop.getProperty("email"));
    login.setPassword(prop.getProperty("password"));
    login.clickLogin();

    Assert.assertTrue(login.isMyAccountPageDisplayed());
}

▶️ How to Run the Tests
🔹 Run via TestNG XML

Right-click testng.xml

Select Run As → TestNG Suite

🔹 Run via Maven
mvn test

🧪 Test Execution Control
🔹 Run by TestNG Groups
<groups>
    <run>
        <include name="sanity"/>
    </run>
</groups>

🔹 Parallel Execution
<suite parallel="tests" thread-count="3">

📊 Reports & Logs
📈 Extent Report

Generated automatically after execution

Path:

/test-output/ExtentReport.html

📸 Screenshots

Automatically captured on test failure

Stored under:

/screenshots

🧠 Framework Design Philosophy

Built for enterprise UI automation

Clear separation of concerns

Easy to maintain and extend

Follows real client project standards

Ideal for interviews & production use

🧩 Future Enhancements

Jenkins CI/CD pipeline

Selenium Grid / Docker support

Cloud execution (BrowserStack / Sauce Labs)

API Automation integration (Rest Assured)

👨‍🏫 Author

Santosh Chandrawanshi
CloudBerry QA Automation
Selenium | Java | Hybrid Framework | TestNG | CI/CD

⭐ Support

If you find this framework useful:

⭐ Star the repository

🍴 Fork it

🧠 Learn & customize for your projects
