package com.owino.securityapp.persistance_tests;

import com.owino.securityapp.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class PersistUserTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldPersistUserTest(){
        var user = TestUtils.createUser();
        var entity = entityManager.persistAndFlush(user);

        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getId()).isEqualTo(user.getId());
        Assertions.assertThat(entity.getUserName()).isEqualTo(user.getUserName());
        Assertions.assertThat(entity.getEmail()).isEqualTo(user.getEmail());
        Assertions.assertThat(entity.getPassword()).isEqualTo(user.getPassword());
    }
}
