package com.owino.jpacode.object_creation_tests;

import com.owino.jpacode.entities.base.TweetMetadata;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateTweetMetadataClassTest {
    @Test
    public void shouldCreateTweetMetadataClassTest(){
        var metadata = new TweetMetadata("Community Tweet", LocalDateTime.now());

        Assertions.assertThat(metadata.getTweetType()).isEqualTo("Community Tweet");
        Assertions.assertThat(metadata.getCreated()).isNotNull();
    }
}
