package com.owino.jpacode.object_creation_tests;

import com.owino.jpacode.entities.Tweet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateTweetTest {
    @Test
    public void shouldCreateTweetTest(){
        var tweet = new Tweet(1L,"#goodvibes #sweetypie", "2022-12-11","11:00PM");
        Assertions.assertThat(tweet).isNotNull();
    }
}
