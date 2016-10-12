package com.atf.otd.service;

import java.io.ByteArrayOutputStream;

import com.atf.otd.controller.request.EmailRequest;
import com.atf.otd.controller.request.OneTimeDownloadRequest;

public interface OneTimeDownloadService {

	public boolean validateId(OneTimeDownloadRequest otd);
	
	public boolean recordEmail(EmailRequest email);
	
	public ByteArrayOutputStream getSFMStream();
	
}
