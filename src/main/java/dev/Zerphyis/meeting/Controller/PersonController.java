package dev.Zerphyis.meeting.Controller;

import dev.Zerphyis.meeting.Entity.Person.Person;
import dev.Zerphyis.meeting.Entity.Records.LoginData;
import dev.Zerphyis.meeting.Entity.Records.PersonResponseDto;
import dev.Zerphyis.meeting.Entity.Records.ResponseToken;
import dev.Zerphyis.meeting.Security.ServiceToken;
import dev.Zerphyis.meeting.Service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class PersonController {


    @Autowired
    private PersonService personService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ServiceToken tokenService;

    @PostMapping("/register")
    public PersonResponseDto registerUser(@RequestBody @Valid Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        Person savedPerson = personService.createPerson(person);
        return new PersonResponseDto(savedPerson.getName(), savedPerson.getEmail(), savedPerson.getPassword(), savedPerson.getRole().name());
    }

    @PostMapping("/auth")
    public ResponseEntity<ResponseToken> login(@RequestBody LoginData loginRequest) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.name(), loginRequest.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Person authenticatedPerson = (Person) authentication.getPrincipal();

        if (authenticatedPerson.getName().equals(loginRequest.name()) && authenticatedPerson.getEmail().equals(loginRequest.email())) {
            String token = tokenService.generateToken(authenticatedPerson);

            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseToken(token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}


