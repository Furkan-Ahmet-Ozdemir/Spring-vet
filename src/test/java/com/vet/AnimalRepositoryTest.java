package com.vet;

import com.vet.model.Animal;
import com.vet.model.User;
import com.vet.repository.AnimalRepository;
import com.vet.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AnimalRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    public void testCreateAnimal() {
        User user = new User(1,"mehmet@gmail.com","gererherh","4574457","Mehmet","asfg");
        User savedUser = userRepository.save(user);
        Animal animal = new Animal(1,"pamuk","Köpek","Erkek",4,"İyi huylu",savedUser);
        Animal savedAnimal = animalRepository.save(animal);

        Animal existAniaml = entityManager.find(Animal.class,savedAnimal.getId());
        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(animal.getAge()).isNotNull();
        assertThat(animal.getName()).isNotNull();
        assertThat(user.getFirstName()).isEqualTo(savedAnimal.getUser().getFirstName());
    }

    @Test
    public void testUpdateAnimal() {
        User user = new User(1,"mehm234et1@gmail.com","gererherh","457457457","Mehmet","asfg");
        User savedUser = userRepository.save(user);
        Animal animal = new Animal(1,"pamuk","Köpek","Erkek",4,"İyi huylu",user);
        Animal savedAnimal = animalRepository.save(animal);

        Animal animal2 = savedAnimal;
        animal2.setAge(5);

        Animal existAniaml = entityManager.find(Animal.class,savedAnimal.getId());
        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(savedAnimal.getAge()).as("check %s's age", savedAnimal.getName()).isEqualTo(animal2.getAge());
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }

    @Test
    public void testDeleteAnimal() {

        User user = new User(1,"veli@gmail.com","wehhwh","234234234","Veli","asfg");
        User savedUser = userRepository.save(user);

        Animal animal = new Animal(1,"pamuk2","Köpek1","Erkek",5,"İyi huylu",user);
        Animal savedAnimal = animalRepository.save(animal);

        animalRepository.delete(savedAnimal);
        Animal existAnimal = entityManager.find(Animal.class, savedAnimal.getId());

        assertThat(existAnimal).isNull();
    }

}
