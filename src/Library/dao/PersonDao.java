package Library.dao;

import java.util.ArrayList;
import java.util.List;

import Library.models.Person;
import Library.services.BaseDao;

public class PersonDao implements BaseDao<Person, Integer>{

    List<Person> person = new ArrayList<>();

    @Override
    public void save(Person data) {
        person.add(data);
    }

    @Override
    public List<Person> findAll() {
        return this.person;
    }

    @Override
    public Person findById(Integer id) {
        return this.person.get(id - 1);
    }

    @Override
    public void update(Integer id, Person data) {
        person.set(id - 1, data);
    }

    @Override
    public void delete(Integer id) {
        person.remove(id -1 );
    }
    
}
