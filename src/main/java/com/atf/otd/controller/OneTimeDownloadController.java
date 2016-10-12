package com.atf.otd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atf.otd.controller.request.EmailRequest;
import com.atf.otd.controller.request.OneTimeDownloadRequest;
import com.atf.otd.service.OneTimeDownloadServiceImpl;

@Controller
public class OneTimeDownloadController {

	@Autowired
	private OneTimeDownloadServiceImpl otdService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String indexRequest(Model model) {
		model.addAttribute("otd", new OneTimeDownloadRequest());
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String indexResponse(@ModelAttribute OneTimeDownloadRequest otd, Model model) {
		String page = "error";
		
		boolean validCode = otdService.validateId(otd);
		if(validCode) {
			page = "download";
			model.addAttribute("email", new EmailRequest());
		}
		
		return page;
	}
	
	@RequestMapping(value="/email", method=RequestMethod.POST)
	public String indexResponse(@ModelAttribute EmailRequest email) {
		String page = "error";
		
		boolean success = otdService.recordEmail(email);
		if(success) {
			page = "downloadpostemail";
		}

		return page;
	}
}
