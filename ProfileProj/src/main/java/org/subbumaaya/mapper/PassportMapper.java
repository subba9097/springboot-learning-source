package org.subbumaaya.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.subbumaaya.dto.PassportRequest;
import org.subbumaaya.dto.PassportResponse;
import org.subbumaaya.entity.Passport;

@Mapper(componentModel = "spring")
public interface PassportMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "person", ignore = true)
	Passport toPassport(PassportRequest passportRequest);

	@Mapping(target = "personResponse", ignore = true)
	PassportResponse toPassportResponse(Passport passport);
}
