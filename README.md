Assessment Project for Entrata
This project focuses on automating end to end scenarios of Entrata landing page. It utilizes Selenium WebDriver for automated testing and TestNG for test execution.

Features
1. Selenium-Java hybrid framework
2. Page Object Model (POM) design pattern, 
3. TestNG for test management, 
4. Log4j2 for logging and debugging, 
5. Multi-browser testing support, 
6. Retry mechanism for failed test cases, 
7. Extent Report integration - Screenshots for all tests and logs for failed tests 

Technologies Used
1. Java 17 (or higher)
2. Selenium WebDriver (version 4.25.0),
3. TestNG (version 7.10.2),
4 .WebDriverManager (version 5.9.2),
5. Log4j (version 2.24.0),
6. slf4j (version 1.7.32),
7. Extent Reports (version 5.0.9)
   
Installation
Prerequisites: Ensure you have Java (version 17 or higher) installed on your system.
Maven Setup: Clone or download the project repository. It's recommended to use a tool like Maven to manage dependencies.

Usage
1. Running Tests:
Navigate to the project directory in your terminal.
mvn verify

Use code with caution.
This command will compile the project code, launch tests, and generate reports.

2. Test Reports:
Test reports will be generated in the target/surefire-reports directory.
Extent Reports can be found within this directory for a more detailed view of test execution with Screenshots for all tests and logs for failed tests

3. Project Structure:
The project follows a standard POM structure

  

