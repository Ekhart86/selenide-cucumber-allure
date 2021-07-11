
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

![Last-screen](https://user-images.githubusercontent.com/25115868/92218097-43088a80-eea1-11ea-902d-d0e55cad28f8.PNG)

-------------------------------------------------------------------------------------------------------

If the tests are run on a remote machine in selenoid, then a video of the test execution will be attached to each test.

![last-video](https://user-images.githubusercontent.com/25115868/92218131-51ef3d00-eea1-11ea-8aee-10432abdf247.PNG)

