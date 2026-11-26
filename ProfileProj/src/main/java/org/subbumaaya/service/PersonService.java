package org.subbumaaya.service;

import org.subbumaaya.dto.PersonRequest;
import org.subbumaaya.dto.PersonResponse;

public interface PersonService {

	PersonResponse addPersonDetails(PersonRequest personRequest);
	
	PersonResponse getPersonDetails(Long id);

}
