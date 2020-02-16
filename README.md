# selenide-cucumber4-allure2 project

Java and Maven must be installed on your computer before running tests.

To run tests, you need to download the project, 
go to the project folder, and call command in the terminal:

mvn clean test allure:serve

The first run of the tests will take a little longer, 
since Maven will download all the dependencies that the project needs.

The project uses the Selenide framework. It uses WebDriverManager
which itself downloads the latest version of the browser that you specified in the configuration. 
By default, this is the latest version of the Chrome browser.

The Internet must be available on the computer without restrictions. 
If your computer has Internet access via Proxy server, 
you must add the following lines to the project settings:

System.setProperty("wdm.proxy", url);

System.setProperty("wdm.proxyUser", url);

System.setProperty("wdm.proxyPass", url);

After running the tests, the local Allure server will be automatically launched,
with a report on running the tests.

A screenshot of this step will be attached to each step in the report. 
If this is not necessary, you can remove the creation of screenshots. 
You can also adjust their size.

![screen_001](https://user-images.githubusercontent.com/25115868/74601464-c8685100-50af-11ea-9c33-efb4fa4a1a02.png)

![screen_002](https://user-images.githubusercontent.com/25115868/74601470-d8803080-50af-11ea-977c-3086eeb720d9.png)
