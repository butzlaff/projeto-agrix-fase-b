package com.betrybe.agrix.solution;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("Req 02 - Testa Person Service")
public class PersonServiceTest {
  MockMvc mockMvc;
  @Autowired
  private PersonService personService;

  @MockBean
  PersonRepository personRepository;

  @Test
  @DisplayName("should create a Person")
  public void testCreatePerson() {
    Person personMock = new Person();
    personMock.setUsername("teste");
    personMock.setPassword("123456");
    personMock.setRole(Role.ADMIN);
    personMock.setId(1L);
    Mockito.when(
        personRepository.save(Mockito.any(Person.class))).thenReturn(personMock);

    Person person = personService.create(personMock);
    assertEquals(personMock, person);
    assertEquals(personMock.getId(), person.getId());
    assertEquals(personMock.getUsername(), person.getUsername());
    assertEquals(personMock.getPassword(), person.getPassword());
  }
  
  @Test
  @DisplayName("should get a Person by ID")
  public void testGetPersonById() {
    Person personMock = new Person();
    personMock.setUsername("teste");
    personMock.setPassword("123456");
    personMock.setRole(Role.ADMIN);
    personMock.setId(1L);

    Mockito.when(
        personRepository.findById(1L)).thenReturn(Optional.of(personMock));

    Person person = personService.getPersonById(1L);

    assertEquals(personMock, person);
    assertEquals(personMock.getId(), person.getId());
    assertEquals(personMock.getUsername(), person.getUsername());
    assertEquals(personMock.getPassword(), person.getPassword());
  }
  
  @Test
  @DisplayName("should throws a Error when not found a Person")
  public void testGetPersonByIdNotFound() throws PersonNotFoundException {
    Mockito.when(
        personRepository.findById(999L)).thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> {
      personService.getPersonById(999L);
    });
  }

  @Test
  @DisplayName("should return a person")
  void testGetPersonByUsername() {
    // Test case 1: Person exists in the repository
    String existingUsername = "john";
    Person existingPerson = new Person();
    existingPerson.setUsername(existingUsername);
    existingPerson.setPassword("123456");
    existingPerson.setRole(Role.ADMIN);

    Mockito.when(personRepository.findByUsername(Mockito.any()))
        .thenReturn(Optional.of(existingPerson));

    Person result = personService.getPersonByUsername(existingUsername);
    assertEquals(existingPerson, result);
  }
  
  @Test
  @DisplayName("shoudl throws a error")
  void testGetPersonByUsernameNotFound() {
    // Test case 2: Person does not exist in the repository
    String nonExistingUsername = "john";
    Mockito.when(personRepository.findByUsername(Mockito.any()))
        .thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class,
            () -> personService.getPersonByUsername(nonExistingUsername));
  }
}
