# selenide-cucumber4-allure2 project

Run test - mvn clean test -Dbrowser=chrome -Dheadless=1 

or just mvn clean test

parameters:

browser - chrome or firefox. default - chrome

headless - 0 or 1. default - 0

Generate allure report - mvn allure:serve



The project uses Spring Context to interact with application pages

Java 8 and Maven 3.6+ must be installed on your computer before running tests.

To run tests, you need to download the project, 
go to the project folder, and call command in the terminal:

mvn clean test 

mvn allure:serve


The first run of the tests will take a little longer, 
since Maven will download all the dependencies that the project needs.

The project uses the Selenide framework. Selenide uses WebDriverManager
which itself downloads the latest version of the browser that you specified in the configuration. 
By default, this is the latest version of the Chrome browser.

The Internet must be available on the computer without restrictions. 
If your computer has Internet access via Proxy server, 
you must add the following lines to the project settings:

System.setProperty("wdm.proxy", "url");

System.setProperty("wdm.proxyUser", "user");

System.setProperty("wdm.proxyPass", "password");

After running the tests, the local Allure server will be automatically launched,
with a report on running the tests.

A screenshot of this step will be attached to each step in the report. 
If this is not necessary, you can remove the creation of screenshots. 
You can also adjust their size.
![cucumber_parallel](https://user-images.githubusercontent.com/25115868/91716912-2c102280-eb99-11ea-83e7-38e6c14f8919.PNG)

If you need to record a video of the test running, mark this test with the @video annotation

![video](https://user-images.githubusercontent.com/25115868/91716946-3c280200-eb99-11ea-9f80-e5fd9cd8172d.PNG)

Then a video of the test execution will be attached to the report in the TearDown section, which you can download and watch.
![video-2](https://user-images.githubusercontent.com/25115868/91716970-45b16a00-eb99-11ea-9a00-248ddef905a9.PNG)

Video recording is only possible when running tests in a single thread! Remember this!


By default, tests are executed in one thread, if parallel execution is needed, then you need to uncomment the lines in POM.xml. 
It is possible to set either the exact number of streams or unlimited.

![Parallel](https://user-images.githubusercontent.com/25115868/91717205-b193d280-eb99-11ea-8c89-1557d98a55b5.PNG)

Parallel execution is possible only at the level of script files.
