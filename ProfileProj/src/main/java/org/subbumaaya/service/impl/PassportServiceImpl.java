package org.subbumaaya.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.subbumaaya.dto.PassportRequest;
import org.subbumaaya.dto.PassportResponse;
import org.subbumaaya.dto.PersonResponse;
import org.subbumaaya.entity.Passport;
import org.subbumaaya.entity.Person;
import org.subbumaaya.mapper.PassportMapper;
import org.subbumaaya.mapper.PersonMapper;
import org.subbumaaya.repository.PassportRepository;
import org.subbumaaya.service.PassportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {


	private final PassportRepository passportRepository;

	private final PassportMapper passportMapper;

	private final PersonMapper personMapper;

	

	@Override
	public PassportResponse getPassportDetails(Long id) {
		Passport passport = passportRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found"));
		PersonResponse personResponse = personMapper.toPersonResponse(passport.getPerson());
		PassportResponse passportResponse = passportMapper.toPassportResponse(passport);
		passportResponse.setPersonResponse(personResponse);
		return passportResponse;
	}

	@Override
	public List<PassportResponse> getAllPassportDetails() {

		List<Passport> list = passportRepository.findAll();

		List<PassportResponse> listOfPassRes = new ArrayList<>();

		for (Passport passport : list) {
			PersonResponse personResponse = personMapper.toPersonResponse(passport.getPerson());
			PassportResponse passportResponse = passportMapper.toPassportResponse(passport);
			passportResponse.setPersonResponse(personResponse);
			listOfPassRes.add(passportResponse);
		}

		return listOfPassRes;
	}

	@Override
	public PassportResponse addPassport(PassportRequest passportRequest) {

		Person person = personMapper.toPerson(passportRequest.getPersonRequest());

		Passport passport = passportMapper.toPassport(passportRequest);

		person.setPassport(passport);

		passport.setPerson(person);

		Passport savedPassport = passportRepository.save(passport);

		PersonResponse personResponse = personMapper.toPersonResponse(savedPassport.getPerson());

		PassportResponse passportResponse = passportMapper.toPassportResponse(savedPassport);

		passportResponse.setPersonResponse(personResponse);

		return passportResponse;
	}

	@Override
	public void deletePassport(Long id) {

		if (!passportRepository.existsById(id))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found");
		passportRepository.deleteById(id);

	}

}
