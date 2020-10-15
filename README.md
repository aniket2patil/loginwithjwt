# loginwithjwt
Java-Spring-Boot: Login With JWT

# Prerequisites
- Java >= 1.8
- Maven
- JRE 

This project is to illustrate how we can create JWT token after successful login. 
Other API is illustrate how JWT token can be used as session token subsequent requests.



**API**
```
curl --location --request POST 'http://127.0.0.1:8080/signin' \
--header 'Content-Type: application/json' \
--data-raw '{
"firstName": "Aniket",
"lastName": "Patil",
"email": "test@test.com",
"password": "test"
}'

```
**Description**

This API is to signin with user data. Validation of user data is not done in API. For all the values it will be successful. This is just to illustrate that how can we use user data to create JWT token. 
