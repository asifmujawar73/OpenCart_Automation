### OpenCart Hybrid Automation Framework

**Project Overview**:
The OpenCart Hybrid Automation Framework is a comprehensive automation testing solution built for testing the functionalities of an OpenCart e-commerce website. This framework follows the Hybrid Driven approach, integrating Data-Driven, Keyword-Driven, and Modularization principles, enabling robust, reusable, and maintainable test cases.

**Technologies Used**:
- **Java**: The primary programming language.
- **Selenium WebDriver**: For automating web interactions.
- **TestNG**: For managing test execution, grouping, and reporting.
- **Maven**: For dependency management and project build.
- **ExtentReports**: For generating detailed and customizable HTML reports.
- **Docker and Selenium Grid**: For cross-browser, parallel, and remote testing.

**Framework Structure**:
1. **Page Object Model (POM)**:
   - The framework uses the POM design pattern, with classes representing each page in the OpenCart application. Each class contains locators and reusable methods related to specific page functionalities, improving test readability and maintainability.
   
2. **Configurable Properties**:
   - Common test data, such as URLs, usernames, and passwords, are managed in `config.properties`, making it easy to configure and switch environments.

3. **Test Data and Utilities**:
   - **Excel-based Data-Driven Testing**: Data for tests, especially for login and other form-based functionality, is managed through Excel files, using the custom `ExcelUtility` class.
   - **Utilities**: Includes reusable utilities like `DataProviders` for parameterized testing, `ExtentReportUtility` for report generation, and `BaseClass` for core setup and teardown methods.

**Key Features**:
1. **Cross-Browser Testing**:
   - The framework supports running tests on multiple browsers and operating systems through parameterized TestNG XML files, with the `BaseClass` setup to handle different configurations.

2. **Logging with Log4j**:
   - Integrated logging provides detailed insight into each test step, helping with troubleshooting and analysis.

3. **Grouping and Parallel Execution**:
   - Test cases are grouped into `Sanity`, `Regression`, `Master`, etc., allowing selective execution of tests based on needs. Parallel and cross-browser tests are configured in TestNG XML, optimizing execution time.

4. **Execution on Selenium Grid and Docker**:
   - Configured to support remote execution through Selenium Grid, including Dockerized environments, enabling tests to run on distributed nodes, enhancing scalability, and supporting CI/CD pipelines.

5. **Continuous Integration (CI) with Jenkins**:
   - The project can be integrated with Jenkins for automated test execution. Test results and reports are generated after each build, ensuring quality assurance throughout the development lifecycle.

6. **Retry for Failed Tests**:
   - Automatically re-runs failed tests using TestNG’s failed test suite (`test-output/testng-failed.xml`), minimizing manual rework and providing resilience to flaky tests.

**Test Case Coverage**:
1. **Account Registration**: Tests the registration functionality, verifying that new users can register successfully.
2. **Account Login**: Validates login with valid and invalid credentials, confirming access restrictions.
3. **Product Search and Wishlist**: Simulates a product search and adding a product to the wishlist, verifying that items appear correctly.
4. **Data-Driven Login Test**: Uses Excel data to test various login scenarios with multiple credentials.
5. **Shopping Cart Verification**: Adds items to the cart and verifies the total price and checkout functionality.

**Execution Instructions**:
1. **Run Tests Locally**:
   - Configure `config.properties` for local execution and specify `local` for `execution_env`.
   - Execute through TestNG XML or `mvn test` commands.

2. **Run Tests Remotely with Grid**:
   - Setup Selenium Grid, configure `execution_env` as `remote`, and run the tests from TestNG XML.

3. **Run Tests in Docker Environment**:
   - With Docker installed, set up the Docker Selenium Grid, and use the `docker-compose` setup to run tests in an isolated environment.

4. **CI/CD Pipeline Setup**:
   - Integrate with Jenkins for scheduled or triggered execution upon code changes, utilizing GitHub for version control.

**Project Benefits**:
This automation suite enables thorough testing of the OpenCart application, reduces manual testing efforts, and ensures rapid feedback. Its modular, data-driven, and scalable design allows easy maintenance, adaptation to new requirements, and integration into CI/CD workflows.
