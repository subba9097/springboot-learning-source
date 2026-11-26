package org.subbumaaya.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.subbumaaya.dto.PassportResponse;
import org.subbumaaya.dto.PersonRequest;
import org.subbumaaya.dto.PersonResponse;
import org.subbumaaya.entity.Passport;
import org.subbumaaya.entity.Person;
import org.subbumaaya.repository.PersonRepository;
import org.subbumaaya.service.PersonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	private final ModelMapper modelMapper;

	@Override
	public PersonResponse addPersonDetails(PersonRequest personRequest) {

//		Passport passport = passportMapper.toPassport(personRequest.getPassportRequest());
		Passport passport = modelMapper.map(personRequest.getPassportRequest(), Passport.class);
//		Person person = personMapper.toPerson(personRequest);
		Person person = modelMapper.map(personRequest, Person.class);
		person.setPassport(passport);
		Person savedPerson = personRepository.save(person);
//		PassportResponse passportResponse = passportMapper.toPassportResponse(savedPerson.getPassport());
		PassportResponse passportResponse = modelMapper.map(savedPerson.getPassport(), PassportResponse.class);
//		PersonResponse personResponse = personMapper.toPersonResponse(savedPerson);
		PersonResponse personResponse = modelMapper.map(savedPerson, PersonResponse.class);
		personResponse.setPassportResponse(passportResponse);
		return personResponse;
	}

	@Override
	public PersonResponse getPersonDetails(Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found"));
		PassportResponse passportResponse = modelMapper.map(person.getPassport(), PassportResponse.class);
		PersonResponse personResponse = modelMapper.map(person, PersonResponse.class);
		personResponse.setPassportResponse(passportResponse);
		return personResponse;
	}

	@Override
	public List<PersonResponse> getPersonsDetails() {

		List<Person> listOfPerson = personRepository.findAll();
		List<PersonResponse> list = new ArrayList<>();

		for (Person person : listOfPerson) {
			PassportResponse passportResponse = modelMapper.map(person.getPassport(), PassportResponse.class);
			PersonResponse personResponse = modelMapper.map(person, PersonResponse.class);
			personResponse.setPassportResponse(passportResponse);
			list.add(personResponse);
		}

		return list;
//		List<PersonResponse> list = listOfPerson.stream().map(person -> {
//			PassportResponse passportResponse = modelMapper.map(person.getPassport(), PassportResponse.class);
//			PersonResponse personResponse = modelMapper.map(person, PersonResponse.class);
//			personResponse.setPassportResponse(passportResponse);
//			return personResponse;
//		}).collect(Collectors.toList());
//		return list
	}

	@Override
	public void deletePersonDetails(Long id) {

		if (!personRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found");
		}

		personRepository.deleteById(id);

	}

}
