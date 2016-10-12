package com.atf.otd.service;

import com.atf.otd.controller.request.EmailRequest;
import com.atf.otd.controller.request.OneTimeDownloadRequest;

public interface OneTimeDownloadService {

	public boolean validateId(OneTimeDownloadRequest otd);
	public boolean recordEmail(EmailRequest email);
	
}
