package com.owino.securityapp.create_objects_tests;

import com.owino.securityapp.database.entities.User;
import org.junit.jupiter.api.Test;

public class CreateUserTest {

    @Test
    public void shouldCreateUserTest(){
        var user = new User(1L,"Bender","bendersmith@yahoo.com","strongEncodedPassword");
    }
}
