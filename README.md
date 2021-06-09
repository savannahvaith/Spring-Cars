# Response Entities

`ResponseEntity` represents the whole HTTP response: 

* Status Code
* Headers
* Body 

We can use it to configure the Response that is sent from Spring to the Presentation Layer. 

```java

public ResponseEntity<List<Car>> getAll(){
	return new ResponseEntity<Car>(this.vehicle, HttpStatus.OK); 
}
```

These are used in the `Controller` component of the application. 

