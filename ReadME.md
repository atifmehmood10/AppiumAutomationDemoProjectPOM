# Appium Android Automation Project using TestNG in Java

Welcome to the Appium Android Automation project using TestNG in Java! This project allows you to automate tests for Android applications using the Appium framework and TestNG as the testing framework. This README file will guide you through the setup process and provide instructions on how to run the tests and generate a report using Allure.

## Prerequisites

Before you begin, please ensure you have the following dependencies and configurations set up on your machine:

1. **Java**: Install Java Development Kit (JDK) and set the `JAVA_HOME` environment variable to the JDK installation directory.

2. **Maven**: Install Maven and set the `MAVEN_HOME` and `M2_HOME` environment variables to the Maven installation directory.

3. **Allure Reports CLI Tool**: Install Allure Reports CLI Tool version 2.23.0 as mentioned in the project's `pom.xml` file.

## Getting Started

Follow these steps to set up and run the project:

1. Clone the repository or download the project source code to your local machine.

2. Open a terminal and navigate to the project directory.

3. **Run Tests**: Execute the following command to clean and run the tests using Maven:
This command will trigger the execution of the TestNG tests on the connected Android device/emulator using the Appium framework.

4. **Generate and View Report**: After the tests have completed, generate an Allure report using the following command:
This will generate an HTML report with detailed information about the test results, including screenshots, logs, and more. The report will be automatically opened in your default web browser.

## Project Structure

The project is structured as follows:

- `src/test/java`: Contains the test scripts written in Java using TestNG annotations.
- `src/main/resources`: Contains any required resources, such as configuration files.
- `allure-results`: This directory will be generated after running tests and will contain the raw data needed to generate the Allure report.

## Test Configuration

You can customize the test configuration by modifying the `src/main/resources/config.properties` file. This file contains parameters like the device name, platform version, app path, and other settings needed for test execution.

