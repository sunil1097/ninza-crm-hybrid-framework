# Ninza CRM Hybrid Automation Framework

## 📌 Overview
This project is a **Hybrid Automation Testing Framework** designed to test the **Ninza CRM web application**.  
It combines the strengths of **Data-Driven Testing (DDT)** and **Keyword-Driven Testing (KDT)** using **Selenium WebDriver**, **TestNG**, and **Java**.

The framework follows **Page Object Model (POM)** for better maintainability, scalability, and reusability of test code.

---

## 🛠 Tech Stack
- **Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **Data Source:** Apache POI (Excel)  
- **Version Control:** GitHub  
- **Reporting:** Extent Reports / TestNG Reports  

---

## 🚀 Features
- Page Object Model for separation of test logic & UI elements  
- Cross-browser testing support  
- Data-driven approach using Excel  
- Easy configuration via `config.properties`  
- Centralized test data management  
- Detailed HTML reports after execution  
- Supports parallel execution with TestNG  

---

## 📂 Project Structure
ninza-crm-hybrid-framework/
│
├── src/main/java/ # Application-independent reusable code
│ ├── base/ # Base classes for WebDriver setup
│ ├── pages/ # Page classes for Ninza CRM
│ ├── utils/ # Utility classes (Excel reader, etc.)
│
├── src/test/java/ # Test scripts
│ ├── tests/ # TestNG test classes
│
├── test-data/ # Excel files & test data
├── config/ # Config properties file
├── reports/ # Generated HTML reports
│
├── pom.xml # Maven dependencies & plugins
├── README.md # Project documentation

yaml
Copy
Edit

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the repository
```bash
git clone https://github.com/sunil1097/ninza-crm-hybrid-framework.git
2️⃣ Import into Eclipse/IntelliJ
Open your IDE → Import → Existing Maven Project → Select the cloned repo folder

3️⃣ Configure Test Data
Update config.properties with your browser, base URL, and credentials

Place your Excel files in the test-data folder

4️⃣ Install dependencies
bash
Copy
Edit
mvn clean install
▶️ Execution
Run all tests:
bash
Copy
Edit
mvn test
Run specific TestNG suite:
bash
Copy
Edit
mvn clean test -DsuiteXmlFile=CampaignFlow.xml
📊 Reports
After execution:

Extent Reports: Located inside /reports/

TestNG Reports: Located inside /test-output/

🧪 Sample Test Case Flow
Launch browser

Login to Ninza CRM

Navigate to Campaign module

Create new campaign

Validate creation

Logout and close browser

🤝 Contribution
Feel free to fork this repo, make enhancements, and submit a pull request.

📜 License
This project is open-source and available under the MIT License.

yaml
Copy
Edit

---

If you want, I can also add **badges** at the top (Java version, Selenium version, TestNG version, build status) so it looks **very professional for interviews and GitHub visitors**. That will make it stand out.  

Do you want me to add those badges?
