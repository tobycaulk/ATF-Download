package com.atf.otd.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.pmw.tinylog.Logger;
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
	public String indexResponse(@ModelAttribute OneTimeDownloadRequest otd) {
		String page = "error";
		
		boolean validCode = otdService.validateId(otd);
		if(validCode) {
			page = "redirect:/download";
		}
		
		return page;
	}
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public String downloadRequest(Model model) {
		model.addAttribute("email", new EmailRequest());
		return "download";
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
	
	@RequestMapping(value="/downloadSFM", method=RequestMethod.GET)
	public void downloadSFMRequest(HttpServletResponse response) {
		ByteArrayOutputStream stream = otdService.getSFMStream();
		
		try {
			response.setContentType("octet/stream");
			response.setHeader("Content-disposition", "attachment; filename=" + "SummerForMonths.mp3");
			response.getOutputStream().write(stream.toByteArray());
			response.getOutputStream().close();
			response.flushBuffer();
		} catch (IOException e) {
			Logger.error("Could not write bytearray to response");
		}
	}
}
