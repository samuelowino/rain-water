package com.owino.securityapp.persistance_tests;

import com.owino.securityapp.TestUtils;
import com.owino.securityapp.database.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void shouldSavePasswordTest(){
        var user = TestUtils.createUser();
        userRepository.save(user);

        var users = userRepository.findAll();

        Assertions.assertThat(users).isNotEmpty();
        Assertions.assertThat(users.size()).isEqualTo(1);
        Assertions.assertThat(users.get(0)).isNotNull();
        Assertions.assertThat(users.get(0).getId()).isEqualTo(user.getId());
        Assertions.assertThat(users.get(0).getUserName()).isEqualTo(user.getUserName());
        Assertions.assertThat(users.get(0).getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    @Transactional
    public void shouldFindUserByUsernameTest(){
        var user = TestUtils.createUser();
        userRepository.save(user);

        var userOptional = userRepository.findByUserName(user.getUserName());

        Assertions.assertThat(userOptional).isNotEmpty();
        Assertions.assertThat(userOptional.get()).isNotNull();
        Assertions.assertThat(userOptional.get().getUserName()).isEqualTo(user.getUserName());
        Assertions.assertThat(userOptional.get().getPassword()).isEqualTo(user.getPassword());
        Assertions.assertThat(userOptional.get().getId()).isEqualTo(user.getId());
    }


}
