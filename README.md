# selenide-cucumber4-allure2 project

Java and Maven must be installed on your computer before running tests.

To run tests, you need to download the project, 
go to the project folder, and call command in the terminal:

mvn clean test alure:serve 

The first run of the tests will take a little longer, 
since Maven will download all the dependencies that the project needs.

After running the tests, the local Allure server will be automatically launched,
with a report on running the tests.

A screenshot of this step will be attached to each step in the report. 
If this is not necessary, you can remove the creation of screenshots. 
You can also adjust their size.
