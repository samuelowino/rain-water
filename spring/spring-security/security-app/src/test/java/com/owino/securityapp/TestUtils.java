package com.owino.securityapp;

import com.owino.securityapp.database.entities.User;

public class TestUtils {
    public static User createUser() {
        var id = 1L;
        var name = "John Wick";
        var email = "bounty.wich@gmail.com";
        var password = "$%##JHGJHGJH&*&23";
        return new User(id, name, email, password);
    }
}
