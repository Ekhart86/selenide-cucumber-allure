
A project using Cucumber, Selenide, Allure, SpringBootTest, Selenoid with the ability to run tests in parallel, in docker containers.
 -------------------------------------------------------------------------------------------------------------------



Run test: mvn clean test


Available parameters:


+ -Dbrowser=firefox | (default chrome)

+ -Dheadless=1 | (default 0)

+ -Dremote=true | (default false)

+ -Dparallel=method | (default false)

+ -DthreadCount=2 or -DuseUnlimitedThreads=true | (default false)



Generate allure report: mvn allure:serve

------------------------------------------------------------------------------------------------------------

The project uses Spring Context to interact with application pages

Java 8 and Maven 3.6+ must be installed on your computer before running tests.

The first run of the tests will take a little longer, 
since Maven will download all the dependencies that the project needs.

The project uses the Selenide framework. Selenide uses WebDriverManager
which itself downloads the latest version of the browser that you specified in the configuration. 
By default, this is the latest version of the Chrome browser.

The Internet must be available on the computer without restrictions. 
If your computer has Internet access via Proxy server, 
you must add the following lines to the project settings:

```
System.setProperty("wdm.proxy", "url");

System.setProperty("wdm.proxyUser", "user");

System.setProperty("wdm.proxyPass", "password");
```
-------------------------------------------------------------------------------------------------------

By default, tests are executed in one thread.

If constant parallel execution is required, then you need to uncomment the lines in the POM.xml.

Parallel execution is possible only at the level of script files

Set up the configuration configuration maven-surefire-plugin:
```
   <parallel>methods</parallel>
   <threadCount>2</threadCount>
   <useUnlimitedThreads>true</useUnlimitedThreads>
```

-------------------------------------------------------------------------------------------------------

After running the tests, the local Allure server will be automatically launched, with a report on running the tests.

If the test ends with an error, then a screenshot of the screen will be attached to this test

![Last-screen](https://user-images.githubusercontent.com/25115868/92218097-43088a80-eea1-11ea-902d-d0e55cad28f8.PNG)

-------------------------------------------------------------------------------------------------------

If the tests are run on a remote machine in selenoid, then a video of the test execution will be attached to each test.

![last-video](https://user-images.githubusercontent.com/25115868/92218131-51ef3d00-eea1-11ea-8aee-10432abdf247.PNG)

