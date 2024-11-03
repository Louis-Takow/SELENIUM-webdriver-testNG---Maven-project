# Web UI Automation - SNIPE-IT Authentication Tests

This project focuses on developing automated UI tests using Selenium for the SNIPE-IT application, specifically validating user authentication functionalities.

## Prerequisites

- **Java Development Kit (JDK):** Ensure you have JDK 8 or later installed. You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
- **Maven:** Ensure you have Maven installed for managing project dependencies. You can download it from [Maven](https://maven.apache.org/download.cgi).
- **IDE:** It is recommended to use IntelliJ IDEA or Eclipse as your Integrated Development Environment (IDE) for this project.

## Setup Instructions

1. **Clone this repository** using your preferred command line tool.
2. Navigate to the project directory after cloning by executing `cd SELENIUM-webdriver-testNG---Maven-project` in your terminal or command prompt.
   
   ```bash
   git clone <repository-url>
   cd SELENIUM-webdriver-testNG---Maven-project
   ```

3. **Set up your project:** Import the project into your IDE and ensure all dependencies (e.g., Selenium, TestNG) are correctly added in the `pom.xml` file.

## Running the Tests

1. Open your IDE and locate the `AuthenticationTest` class in the project structure.
2. Run the `AuthenticationTest` class as a TestNG test suite.
3. Monitor the test execution results in the IDE's console output or the TestNG report generated after execution.

## Test Details

### Overview
This automation assessment focuses on validating UI testing for user authentication functionalities in the SNIPE-IT application. The functionalities tested include:

- **User Authentication** with various scenarios:
    - No credentials provided.
    - Only username provided.
    - Only password provided.
    - Invalid username and password.
    - Valid username with an invalid password.
    - Invalid username with a valid password.
    - Successful login with valid credentials followed by logout.

### Test Scenarios

1. **No User Credentials Test:**
    - Attempt to log in without providing any credentials.
    - Assert that the appropriate error messages are displayed.

2. **Only Username Entry Test:**
    - Provide a valid username but no password.
    - Assert that an error message for the password field is displayed.

3. **Only Password Entry Test:**
    - Provide a valid password but no username.
    - Assert that an error message for the username field is displayed.

4. **Invalid Username and Password Test:**
    - Attempt to log in with both invalid credentials.
    - Assert that an error message for incorrect credentials is displayed.

5. **Valid Username and Invalid Password Test:**
    - Provide a valid username with an invalid password.
    - Assert that an error message for incorrect credentials is displayed.

6. **Invalid Username and Valid Password Test:**
    - Provide an invalid username with a valid password.
    - Assert that an error message for incorrect credentials is displayed.

7. **Valid Credentials Login and Logout Test:**
    - Log in with valid credentials.
    - Assert that the user is redirected to the dashboard.
    - Log out and assert that the logout success message is displayed.

## Best Practices
- **Page Object Model (POM):** Implemented to centralize locators and operations within dedicated classes (`LoginPage` and `DashboardPage`), improving organization and reusability across tests for automated UI functionality.
- **Separation of Concerns:** Each test case is designed to focus on a specific functionality, enhancing readability and maintainability of the codebase.
- **Response Validation:** Each UI interaction is followed by assertions to verify the correctness of UI elements, ensuring a consistent user experience.
- **Data Management:** The Hooks file manages the WebDriver setup and teardown, so the tests can run without issues
- **Validate Positive and Negative Path:** Testing valid, invalid and unexpected conditions.

## Conclusion
This README provides a structured overview of the OrangeHRM authentication test automation project. Following the outlined instructions will allow for seamless setup and execution of the UI tests.
```
