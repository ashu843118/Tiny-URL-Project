package com.example.tinyUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlResource {
	
	@Autowired
	UrlService urlService;


	@GetMapping("/short-url")
	public ServiceResponse getShortUrl(@RequestParam String URL) {
		if(URL==null || URL.isEmpty())
			return new ServiceResponse("failure","Invalid input");
		
			return new ServiceResponse("success",urlService.getShortUrl(URL));
		
	}
	
	@GetMapping("/long-url")
	public ServiceResponse getLongUrl(@RequestParam String URL) {
		String str="";
		if(URL==null || URL.isEmpty() || URL.length()<17)
			return new ServiceResponse("failure","Invalid input");
		
		if((str=urlService.getLongUrl(URL))!=null)
			return new ServiceResponse("success",str);
		else
		return new ServiceResponse("failure","No URL in records");
	}

}
