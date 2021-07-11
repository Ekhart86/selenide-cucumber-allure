
A project using Cucumber, Selenide, Allure, Selenoid with the ability to run tests in parallel, in docker containers.
 -------------------------------------------------------------------------------------------------------------------


Run test: mvn clean test

By default, tests execute in one thread.

Available parameters:

+ -DthreadCount=2 | (default 1)

+ -Dcucumber.options="--tags @LoginFailed" | (default @all)

The rest of the test settings are located in the property files in the 'src/main/resources/properties' folder


Generate allure report: mvn allure:serve

------------------------------------------------------------------------------------------------------------

Java 8 and Maven 3.6+ must be installed on your computer before running tests.

The first run of the tests will take a little longer, 
since Maven will download all the dependencies that the project needs.

The project uses the Selenide framework. Selenide uses WebDriverManager
which itself downloads the latest version of the browser that you specified in the configuration. 
By default, this is the latest version of the Chrome browser.


After running the tests, the local Allure server will be automatically launched, with a report on running the tests.

If the test ends with an error, then a screenshot of the screen will be attached to this test

![Снимок экрана 2021-07-12 в 00 58 10](https://user-images.githubusercontent.com/25115868/125211098-9ced9400-e2ac-11eb-8fbb-4ff0780d55a4.png)

![Снимок экрана 2021-07-12 в 01 00 12](https://user-images.githubusercontent.com/25115868/125211107-ab3bb000-e2ac-11eb-9267-c7af05afc63b.png)

