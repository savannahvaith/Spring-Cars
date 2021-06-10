# Custom Queries

Custom Queries are a way for us to write our own code as part of JPQL - Java Persistent Query Language.

Spring is smart enough to figure out what the query would be via the method name that is placed in the repository.

For more control, we could use the @Query('sql statementhere') annotation.


# Swagger

Swagger is a way for us to see the available end points in our API

Add the following dependency to you `pom.xml`

```xml
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-boot-starter</artifactId>
	<version>3.0.0</version>
</dependency> 
```

To see the EndPoints, run your application then navigate to `https://localhost:<PORTNUMBER>/swagger-ui/index.html`.