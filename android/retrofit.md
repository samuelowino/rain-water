# Retrofit
> **Java & Android HTTP Client**

Retrofit generates an implementation of your API interface

```java
interface DrinksAPI {
    @Get("v1/api/cups/{drink}")
    Call<List<Cups>> getCups(@Path("drink") String drink)
}
```

- - -
# Interface Call< T >

An invocation of a retrofit method that sends a request to a webserver and returns a response. **Each call yields it's own HTTP request and response pair.**

> Use **clone()** to make multiple calls with the same parameters to the webserver; this may be used to implement polling or to retry a failed call.

Calls may be executed **synchronously with execute()** or **asynchronously with enqueue(retrofit.Callback< T >)**.

Calls can be cancelled with **cancel()**.

- - -

# @Body

```java
public @interface Body
```
Used in a service method parameter to directly control the request body of the **POST/PUT request**. The object (body) will be serialized using the **Retrofit instance Converter** and the results will be set directly as **the request body**.

- - -

# Interface Callback< T >

Communicates reponses from a server or offline requests. Callbacks are executed using **Retrofits Callback executor**.

```java
// Invoked when a network exception occured during the request.

onFailure(Call< T > call, Throwable t)
```



```java
//Invoked for a received HTTP response.

onSuccess(Call< T > call, Response response)
```

- - -

# Interface Converter< F, T>

```java
public interface Converter< F, T>
```

Converts objects to and from their Http representations.

```java
Retrofit retrofit = 
            new retrofit2.Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
```








