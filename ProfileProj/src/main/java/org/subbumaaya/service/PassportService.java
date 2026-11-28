package org.subbumaaya.service;

import java.util.List;

import org.subbumaaya.dto.PassportRequest;
import org.subbumaaya.dto.PassportResponse;

public interface PassportService {
	
	PassportResponse getPassportDetails(Long id);
	
	List<PassportResponse> getAllPassportDetails();
	
	PassportResponse addPassport(PassportRequest passportRequest);
	
	void deletePassport(Long id);

}
