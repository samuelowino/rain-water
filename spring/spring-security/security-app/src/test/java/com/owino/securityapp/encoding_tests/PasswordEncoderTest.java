package com.owino.securityapp.encoding_tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

public class PasswordEncoderTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(PasswordEncoderTest.class);

    @Test
    public void shouldEncodePasswordTest() {
        String plainPassword = "1234567Password"; //not recommended password
        var encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        var encodedPassword = encoder.encode(plainPassword);

        LOGGER.info("Plain password: " + plainPassword + " encoded password " + encodedPassword);

        Assertions.assertThat(encodedPassword).isNotNull();
        Assertions.assertThat(encodedPassword).isNotEqualTo(plainPassword);
    }

    @Test
    public void shouldDecodePasswordTest(){
        String plainPassword = "1234567Password"; //not recommended password
        var encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        var encodedPassword = encoder.encode(plainPassword);

        var matches = encoder.matches(plainPassword, encodedPassword);

        Assertions.assertThat(matches).isTrue();

        matches = encoder.matches("incorrect-password-=here", encodedPassword);

        Assertions.assertThat(matches).isFalse();
    }
}
