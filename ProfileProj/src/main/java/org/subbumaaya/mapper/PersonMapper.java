package org.subbumaaya.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.subbumaaya.dto.PersonRequest;
import org.subbumaaya.dto.PersonResponse;
import org.subbumaaya.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "passport", ignore = true)
	Person toPerson(PersonRequest personRequest);

	@Mapping(target = "passportResponse", ignore = true)
	PersonResponse toPersonResponse(Person person);
	


}
