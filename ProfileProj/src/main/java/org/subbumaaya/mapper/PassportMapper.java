package org.subbumaaya.mapper;

//import org.mapstruct.Mapper;
import org.subbumaaya.dto.PassportRequest;
import org.subbumaaya.dto.PassportResponse;
import org.subbumaaya.entity.Passport;

//@Mapper(componentModel = "spring")
public interface PassportMapper {

	Passport toPassport(PassportRequest passportRequest);

	PassportResponse toPassportResponse(Passport passport);
}
