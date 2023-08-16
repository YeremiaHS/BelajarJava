package Library.services.person;

import java.util.List;

import Library.Exception.BadRequestException;
import Library.dao.PersonDao;
import Library.models.Person;

public class PersonServiceImpl implements PersonService {
    PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao){
        this.personDao = personDao;
    }

    @Override
    public void createPerson(Person person) {
        //validation
        if (person.getUsername() == " ") {
            //exception
            throw new BadRequestException("Username cannot be empty");
        } else {
            personDao.save(person);
            System.out.println("User added");
        }
    }

    @Override
    public List<Person> getAllPerson() {
        return personDao.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        if (id <=0) {
            throw new BadRequestException("Input valid id");
        }
        return personDao.findById(id);
    }
    
}
