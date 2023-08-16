package Library.services.person;

import java.util.List;

import Library.models.Person;

public interface PersonService {
    void createPerson(Person person);

    List<Person>getAllPerson();

    Person getPersonById(Integer id);
}
