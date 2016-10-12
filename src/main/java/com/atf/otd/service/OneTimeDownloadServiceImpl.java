package com.atf.otd.service;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Service;

import com.atf.otd.controller.request.EmailRequest;
import com.atf.otd.controller.request.OneTimeDownloadRequest;

@Service
public class OneTimeDownloadServiceImpl implements OneTimeDownloadService {

	private String codes[] = { "8i5iji", "gbgquj", "e86amo", "jexfc6", "6db6uj", "pk4bwj", "pxeawk", "52xzbc", "6s66zi",
			"mhrct5", "gro8zc", "g5gj5y", "vhxrs8", "5jbuvf", "qi4qys", "7mduyu", "o329kq", "rfkbbo", "yo5iuw",
			"4j38xf", "t7tfeb", "tddqjt", "chgp3x", "j9phfw", "pqkty8", "geb29j", "5gpypu", "7k7ir5", "i8fhnc",
			"i8t8ou", "8k6pmr", "255tkw", "o8vx5k", "6xki38", "sr9jdv", "ib4s6m", "nmjv9a", "kfsctk", "ok2gnv",
			"7opd36", "u88kja", "humecr", "mwjxog", "83bdtn", "o3hs6x", "sajvei", "bt9g2u", "rvx9h6", "d9ukan",
			"uk66cx" };
	
	@Override
	public boolean validateId(OneTimeDownloadRequest otd) {
		boolean valid = false;
		
		for(String c : codes) {
			if(c.equals(otd.getId())) {
				valid = true;
			}
		}
		
		return valid;
	}

	@Override
	public boolean recordEmail(EmailRequest email) {
		boolean success = true;
		Logger.info("!!EMAIL ADDRESS!! [" + email.getEmailAddress() + "]");
		return success;
	}
}
