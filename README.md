# spring-boot-jdbc-template
A simple java web application created using Spring Boot and Spring JDBC Template. Covered Create, Read, Update and Delete operations.

### prerequisites
1. Java 1.8
2. Maven 3.5.2
3. Tomcat 7
4. Postgresql 42.1.4
5. Spring Tool Suite IDE

### setup
1. Clone this project
2. Open as maven project
3. Update maven dependencies
4. Create database table according to `com.springboot.jdbc.model.Employee.java`
5. Change the database configuration accordingly in src/main/resources/application.properties.
6. Run `com.springboot.jdbc.SpringBootJdbcApplication.java`


### code style formatter
[Spring Boot Java Conventions](https://gist.github.com/jyotsnasanthosh/e2fb456f0ff91aa42ad8203e148bff79)
Save this as xml and import into eclipse -> window -> preferences -> java -> code style -> formatter