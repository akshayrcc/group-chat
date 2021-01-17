package com.udacity.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.udacity.mvc.model.MessageForm;
import com.udacity.mvc.service.MessageListService;

@Controller
public class HomeController {

	@Autowired
	private MessageListService messageListService;

//	public HomeController(MessageListService messageListService) {
//		this.messageListService = messageListService;
//	}

	@GetMapping("/home")
	public String getHomePage(@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
		model.addAttribute("greetings", this.messageListService.getMessages());
		return "home";
	}

	@PostMapping("/home")
	public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
		messageListService.addMessages(messageForm.getText());
		model.addAttribute("greetings", this.messageListService.getMessages());
		messageForm.setText("");
		return "home";
	}

//	@RequestMapping("/home")
//	public String getHomePage(Model model) {
//		// model.addAttribute(attributeName:"welcomeMessage", attributeValue:"HeyLow
//		// Worald");
//		model.addAttribute("welcomeMessage", Instant.now().toString());
//		model.addAttribute("greetings", new String[] { "He", "She", "It", "They", "GoodBye" });
//		return "home";
//	}

	@RequestMapping("/simplehome")
	public String getSimpleHomePage(Model model) {
		model.addAttribute("firstVisit", "TRUE");
		return "simple-home";
	}
	
	@PostMapping("/file-upload")
	public String handleFileUpload(@RequestParam("fileUplod")  MultipartFile fileUpload	, Model model) {
		//InputStream fis = new fileUpload.getInputStream();
		return "Home";
	}

}
