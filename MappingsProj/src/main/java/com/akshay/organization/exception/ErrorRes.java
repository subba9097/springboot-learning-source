package com.akshay.organization.exception;

import java.time.LocalDateTime;

public record ErrorRes(LocalDateTime timestamp,int status,String error , String path,String message) {

}
