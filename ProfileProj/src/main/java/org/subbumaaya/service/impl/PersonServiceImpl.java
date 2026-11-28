package org.subbumaaya.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.subbumaaya.dto.PassportResponse;
import org.subbumaaya.dto.PersonRequest;
import org.subbumaaya.dto.PersonResponse;
import org.subbumaaya.entity.Passport;
import org.subbumaaya.entity.Person;
import org.subbumaaya.mapper.PassportMapper;
import org.subbumaaya.mapper.PersonMapper;
import org.subbumaaya.repository.PersonRepository;
import org.subbumaaya.service.PersonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	private final PersonMapper personMapper;

	private final PassportMapper passportMapper;

	@Override
	public PersonResponse addPersonDetails(PersonRequest personRequest) {

		Passport passport = passportMapper.toPassport(personRequest.getPassportRequest());
		Person person = personMapper.toPerson(personRequest);
		person.setPassport(passport);
		Person savedPerson = personRepository.save(person);
		PassportResponse passportResponse = passportMapper.toPassportResponse(savedPerson.getPassport());
		PersonResponse personResponse = personMapper.toPersonResponse(savedPerson);
		personResponse.setPassportResponse(passportResponse);
		return personResponse;
	}

	@Override
	public PersonResponse getPersonDetails(Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found"));
		PassportResponse passportResponse = passportMapper.toPassportResponse(person.getPassport());
		PersonResponse personResponse = personMapper.toPersonResponse(person);
		personResponse.setPassportResponse(passportResponse);
		return personResponse;
	}

	@Override
	public List<PersonResponse> getPersonsDetails() {

		List<Person> listOfPerson = personRepository.findAll();
		List<PersonResponse> list = new ArrayList<>();

		for (Person person : listOfPerson) {
			PassportResponse passportResponse = passportMapper.toPassportResponse(person.getPassport());
			PersonResponse personResponse = personMapper.toPersonResponse(person);
			personResponse.setPassportResponse(passportResponse);
			list.add(personResponse);
		}

		return list;
	}

	@Override
	public void deletePersonDetails(Long id) {

		if (!personRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found");
		}

		personRepository.deleteById(id);

	}

}
