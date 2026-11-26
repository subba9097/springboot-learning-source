package org.subbumaaya.service;

import java.util.List;

import org.subbumaaya.dto.PersonRequest;
import org.subbumaaya.dto.PersonResponse;

public interface PersonService {

	PersonResponse addPersonDetails(PersonRequest personRequest);
	
	PersonResponse getPersonDetails(Long id);
	
	List<PersonResponse> getPersonsDetails();
	
	void deletePersonDetails(Long id);

}
