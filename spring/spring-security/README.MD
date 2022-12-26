# Security 

Spring security requires a Java 8 or higer runtime environment

Spring security provides support for :

**1. Authentication**

**2. Authorization**

**3. Protection from common exploits**

# Spring Security Features: Authentication

Spring security provides comprehensive support for authentication. Authentication is how we verify the identity of who is trying to acess a specific resource. Once authentication is completed, we know the identity and can now perform **authorization**. Spring provides dedicated support for authentication.

## Password Storage

Developers are encourouged to use adaptive one-way functions for password storage. Spring security's **PasswordEncoder interface** is used to perform a way tranformation of the password to let the password be stored securely.

A **PasswordEncoder** is used for storing a password that needs to be compared to a user provided password at the time of authentication.

It is encouraged to replace the long term credentials (password and username) with a short term credential such **OAuth tokens, sessions** and so on.


# DelegatingPasswordEncoder

DelegatingPasswordEncoder supports doing the following:

* **Ensuring that passwords are encoded by using the current password storage recommendations.**

* **Allowing for validating of password using modern and legacy formats**

* **Allow for upgrading the encoding in the future**

Construct a **DelegatingPasswordEncoder** using the **PasswordEncoderFactories**

```java
var passwordEncoder = 
            PasswordEncoderFactories.createDelegatingPasswordEncoder();
```

## Password Storage Format

The general format for a password is:

```text
{id}encodedPassword

//for example:
{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
{noop}password
{pbkdf2}5d923b44a6d129f3ddf3e3c8d29412723dcbde72445e8ef6bf3b508fbf17fa4ed4d6b99ca763d8dc
{scrypt}$e0801$8bWJaSu2IKSn9Z9kM+TPXfOc/9bdYSrN1oD9qfVThWEwdRTnO7re7Ei+fUZRJ68k9lTyuTeUp4of4g24hHnazw==$OAOec05+bXxvuu/1qZ6NUR+xQYvYv7BeL1QxwRpY5Pc=
{sha256}97cde38028ad898ebc02e690819fa220e88c62e0699403e94fff291cfffaf8410849f27605abcbc0
```

- - -

## Protection Against Common Exploits

Spring security provides protection against common exploits.

* **CSRF Attacks**
* **HTTP Headers**
* **HTTP Requests**



