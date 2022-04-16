package com.vet;

import static org.assertj.core.api.Assertions.assertThat;
import com.vet.model.User;
import com.vet.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User(1,"asf@gmail.com","ererh47er4her","6546456456","Hasan","asfg");

        User savedUser = userRepository.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }

    @Test
    public void testUpdateUser() {
        User user = new User(1,"asf@gmail.com","ererh47er4her","6546456456","Hasan","asfg");

        User savedUser = userRepository.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());

        User user2 = savedUser;
        user2.setEmail("asfasf@afasfaf");
        User savedUser2 = userRepository.save(savedUser);

        assertThat(user.getEmail()).isNotEqualTo(existUser.getEmail());
    }


    @Test
    public void testDeleteUser() {
        User user = new User(1,"asf@gmail.com","ererh47er4her","6546456456","Hasan","asfg");

        User savedUser = userRepository.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());

        userRepository.deleteById(existUser.getId());
        User existUser2 = entityManager.find(User.class, savedUser.getId());

        assertThat(existUser2).isNull();
    }



}
