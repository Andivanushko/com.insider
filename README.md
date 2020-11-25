# Insider Test Automation
Technical stack for our project:
- Java 8+
- Selenium Webdriver 3
- TestNg
- Maven
- Allure 2 
- RestAssured
- Lombok (install IDEA plugin if you see compilation errors)

## Run test using command line
- Run all tests: 
```shell script
mvn clean test
```
- Single test class: 
```shell script
mvn clean -Dtest=SimpleTest test
```
- Single test method:
```shell script
mvn clean -Dtest=SimpleTest#firstTest test
```
- Specify browser:
```shell script
mvn clean -Dbrowser.type=firefox test
```
- Generate Allure report:
```shell script
- mvn allure:serve
```

## Allure report for passed test
<p align="center">
    <img src="src/test/resources/screenshots/TestPassed.png">
</p>

## Allure report for failed test with screen shot and stack trace
<p align="center">
    <img src="src/test/resources/screenshots/TestFailed.png">
</p>

## If you have a problem with test run from IDE, you need to add config for TestNg runner
-ea -Dtestng.dtd.http=true
<p align="center">
    <img src="src/test/resources/screenshots/TestNG_config.png">
</p>