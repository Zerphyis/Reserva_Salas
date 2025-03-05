package dev.Zerphyis.meeting.Service;

import dev.Zerphyis.meeting.Entity.Person.Person;
import dev.Zerphyis.meeting.Repositorys.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements UserDetailsService {
    @Autowired
    PersonRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByName(username);
    }

    public Person createPerson(Person person) {
        return repository.save(person);
    }
}
