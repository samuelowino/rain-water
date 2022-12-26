# Spring Security Basics
> In need of a refresher ? or new to Spring Boot development? This repository is meant for you.

## Key Components

# WebMvcConfigurer

Defines callback methods to customize the Java-based configuration for Spring MVC enabled via @EnableWebMvc.

@EnableWebMvc annoted configuration classes may implement this interface to be called back and given a chance to customize the default configuration

# ViewControllerRegistry
> org.springframework.web.servlet.config.annotation

Assists with the registration of simple automated controllers pre-configured with status code and/or a view.

## -addViewController(String urlPathOrPattern)
Map a URL path or pattern to view controller to render a response with the configured status code and view.

> **returns ViewControllerRegistration**

**ViewControllerRegistration** - Assists with the registration of a single view controller.

### Key methods are:

> setStatusCode(HttpStatus statusCode)
Set the status code to set on the response.

> setViewName(String viewName)
Set the view name to return.

```

public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("home")
    registry.addViewController("/").setViewName("home")
}

```

The **addViewControllers** method adds four view controllers. Two of the view controllers reference the view whose name is **home** -defined in **home.html**, and another references the view named **hello** -defined in **hello.html**. 


- - -

> **NOTE**
> If Spring security is on the classpath,Spring Boot **automatically secures all HTTP endpoints** with "basic" authentication. 
>Infact Spring Boot provides you a default login page complete with authorization functionality.

# @EnableWebSecurity

Add this annotation to an **@Configuration class** to have the Spring Security configuration defined in any **WebSecurityConfigurer** or more likely by extending the **WebSecurityConfigurerAdapter** base class and overriding individual methods:

```

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/resources/**");
        //Spring Security should completely ignore URLs starting with /resources/

    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/public/**")
            .permitAll()
            .anyRequest()
            .hasRole("USER").add()
            .formLogin() //enable form based log in
            .permitAll() //set permitAll for all URLs assciated with Form Login
    }
    
    @Override 
    protected void configure(AuthenticationManagerBuilder auth) {
        auth
            .inMemoryAuthentication()
            .withUser("user")
            .password("password")
            .roles("USER")
            .and()
            .withUser("admin")
            .password("password")
            .roles("USER", "ADMIN");
    }

}

```

## WebSecurityConfigurerAdapter: class

Provides a convinient base class for creating a **WebSecurityConfiguere** instance. The implementation allows customization by overriding methods.

## WebSecurityConfigurer: interface

Allow customization to the **WebSecurity**. In most cases, users will use **EnableWebSecurity** and create **Configuration** that extends **WebSecurityConfigurerAdapter** which will automatically be supplied to the **WebSecurity** by the **EnableWebSecurity** annotation.





