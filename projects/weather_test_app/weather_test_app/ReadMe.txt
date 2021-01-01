This is a very basic Weather Update application. It is built using Spring framework, maven and jdk 1.8. 

There are number of dependenciies used including spring web, web mvc, scheduler, ldap security related , jdbc connector and jpa etc. A sample unit test case added using TestNg and Mockito.

Security:
I have added two types of authentication, one is In memory authentication which can be enabled by un-commenting @Configuration annotation in SecurityConfig and can be tested user@test.com; password
Currently LdapSecurityConfig is enabled which uses ldif file, which has user ben;benspassword. I didn't change the credentials in the given sample ldif file.
Signup is not working due to the entries not being added in the ldif file. I think it is not supported but not sure.

Caching:
Ehcache is used to read and write through caching.

Persistence:
Spring's data repository used for persistence. mySql data connector is used to establish connection with the db.

Scheduling:
Spring Scheduling was not required but i leveraged it to create and persist mock data and simulate the live data feed, the data generation logic is random so there is a possibility to find some unrealistic data.

There is another scheduled job to execute stored procedure which is supposed to purge old data to keep the db clean.

CSV Export:
CSV data export is done using super csv apis. This part of the application implements factory pattern which returns the service instance based on the type parameter passed to the factory. The csv data export logic is added in the implementation of the service interface created by factory so that in future if we like to add other type of exports like xml it can be added without any change to the existing logic.

Logging:
Logging is done using spring natural logging api slf4j.

Test Case.
A sample unit test case is added using TestNG and Mockito. Junit could be used instead of TestNg but i wanted to create a test suite which could be executed standalone although i couldn't added much test units.

ThymeLeaf templates:
Thymeleaf templating is used for the view rendering. I initially used AngularJS on the frontside but the angular was not going well with the Thymeleaf i couldn't get a chance to work on it. 

Autowiring:
I used Autowiring mostly for injection of constructor based dependencies, since it makes usage of those classes easy to use in the unit test cases and create mock objects of the classes using wiring those dependecies.


DB Schema: 
Schema files can be found under weather_db_export.

This application has a very basic schema, it consist of a table weather_info as shown below.

temperature	decimal(5,2)	YES			
weather_condition	varchar(15)	YES			
weather_info_id	int(11)	NO	PRI		auto_increment
weather_time	bigint(20)	NO			
city	varchar(20)	YES			


Location table should be added separately and its primary key could be used as the foreign key in the weather_info table.
Since we used ldap and in memory authentiication and no authorization is used otherwise we could have used a user table connected to the roles table to check the specific access rights for the authenticated user using ldap.

A stored procedure is added just as a sample, it can delete the data added prior to the given date.



Jar: Application's jar file is under folder target/wc-1.0-SNAPSHOT-exec.jar

It can be executed from the root pplication folder using following commands
> java -jar target//wc-1.0-SNAPSHOT-exec.jar

OR 

> mvn spring-boot:run


P.S.: The jar file is too large so unable to attach in the email. If Maven is installed on any the machine it can be created by runnning following command in the root folder of the application.

> mvn clean install