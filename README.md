# UI autotest project using Cucumber, Selenide, Allure, SpringBootTest with the ability to run in parallel.



Run test - **mvn clean test**


Available parameters:


browser **-Dbrowser=firefox** | (default chrome)

headless **-Dheadless=1** | (default 0)

remote execute  **-Dremote=true** | (default false)

run parallel    **-Dparallel=method** (default false)

how parallel    **-DthreadCount=2** or **-DuseUnlimitedThreads=true** (default false)

Generate allure report - **mvn allure:serve**

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

**System.setProperty("wdm.proxy", "url");**

**System.setProperty("wdm.proxyUser", "user");**

**System.setProperty("wdm.proxyPass", "password");**

-------------------------------------------------------------------------------------------------------
By default, tests are executed in one thread, if parallel execution is needed, then you need to uncomment the lines in POM.xml. 
It is possible to set either the exact number of streams or unlimited.

![Parallel](https://user-images.githubusercontent.com/25115868/91717205-b193d280-eb99-11ea-8c89-1557d98a55b5.PNG)

Parallel execution is possible only at the level of script files

-------------------------------------------------------------------------------------------------------

After running the tests, the local Allure server will be automatically launched,
with a report on running the tests.

A screenshot of this step will be attached to each step in the report. 
If this is not necessary, you can remove the creation of screenshots. 
You can also adjust their size.
![cucumber_parallel](https://user-images.githubusercontent.com/25115868/91716912-2c102280-eb99-11ea-83e7-38e6c14f8919.PNG)

-------------------------------------------------------------------------------------------------------

If the tests are run on a remote machine in selenoid, then a video of the test execution will be attached to each test.
![new_video](https://user-images.githubusercontent.com/25115868/92081608-fd2dc280-edcb-11ea-9295-4d9772e11603.PNG)
--------------------------------------------------------------------------------------------------------
