## Technical stack for our project:
- Java 8+
- Selenium Webdriver 3
- TestNg
- Maven
- Allure 2 
- Lombok (IDEA plugin required)

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
- Specify browser and test:
```shell script
mvn clean -Dbrowser.type=firefox -Dtest=SimpleTest#firstTest test
```
- Generate Allure report:
```shell script
- mvn allure:serve
```