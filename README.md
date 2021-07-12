
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
------------------------------------------------------------------------------------------------------------

Database settings for tests. 
The easiest way is to install the MySql database in the docker container.

Download Docker Image:
docker pull mysql:5.7

Run database in container with name mysql-test:
docker run --name=mysql-test --env="MYSQL_ROOT_PASSWORD=password" -p 3306:3306 -d mysql:5.7

Check that container is working:
docker ps

Connect to the server using the new root password:
docker exec -it mysql-test mysql -uroot -ppassword

Then run the commands to create the necessary table and fill it inЖ:
mysql> CREATE DATABASE testdb;
mysql> USE testdb;
mysql> CREATE TABLE IF NOT EXISTS Customers
(
          Id INT(10) NOT NULL AUTO_INCREMENT,
          Age INT NOT NULL,
          FirstName VARCHAR(50) NOT NULL,
          LastName VARCHAR(50) NOT NULL,
          CONSTRAINT contacts_pk PRIMARY KEY (Id)
);
mysql> INSERT Customers(Age, FirstName, LastName) VALUES (35, 'Michael', 'Jackson');

Check the created user:
mysql> SELECT * FROM Customers;
+------+------+-----------+----------+
| Id   | Age  | FirstName | LastName |
+------+------+-----------+----------+
|    1 |   35 | Michael   | Jackson  |
+------+------+-----------+----------+
1 row in set (0.00 sec)

Disconnect from the server with the 'exit' command:
mysql> exit
------------------------------------------------------------------------------------------------------------


After running the tests, the local Allure server will be automatically launched, with a report on running the tests.

If the test ends with an error, then a screenshot of the screen will be attached to this test

![Снимок экрана 2021-07-12 в 00 58 10](https://user-images.githubusercontent.com/25115868/125211098-9ced9400-e2ac-11eb-8fbb-4ff0780d55a4.png)

![Снимок экрана 2021-07-12 в 01 00 12](https://user-images.githubusercontent.com/25115868/125211107-ab3bb000-e2ac-11eb-9267-c7af05afc63b.png)

