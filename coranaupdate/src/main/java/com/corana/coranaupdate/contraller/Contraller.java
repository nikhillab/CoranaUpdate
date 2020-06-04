package com.corana.coranaupdate.contraller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.corana.coranaupdate.service.ServiceLayer;

@Controller
public class Contraller {
	@Autowired
	private ServiceLayer service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showToDo(ModelMap modelMap) {
		try {
			List<String[]> myGETRequest = service.MyGETRequest();
			long lengthOfData =  service.lengthOfData();
			modelMap.addAttribute("lists",myGETRequest);
			modelMap.put("lengthOfData",lengthOfData+4);

		} catch (IOException e) {
			e.printStackTrace();
		}
		modelMap.put("name", "Nikhil");
		return "index";
	}


}