package com.owino.jpacode.persistence_tests;

import com.owino.jpacode.entities.Tweet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class PersistTweetTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldPersistTweetTest(){
        var tweet = new Tweet(1L,"#goodvibes #sweetypie", "2022-12-11","11:00PM");
        var entity = entityManager.persistAndFlush(tweet);

        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getId()).isEqualTo(1L);
        Assertions.assertThat(entity.getContents()).isEqualTo("#goodvibes #sweetypie");
        Assertions.assertThat(entity.getDateString()).isEqualTo("2022-12-11");
        Assertions.assertThat(entity.getTimeString()).isEqualTo("11:00PM");
    }
}
