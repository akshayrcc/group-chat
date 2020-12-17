package com.udacity.mvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class MessageListService {

	private List<String> messages;

	@PostConstruct
	public void postConstruct() {
		this.messages = new ArrayList<>();
	}

	public List<String> getMessages() {
		return new ArrayList<>(this.messages);
	}

	public void addMessages(String message) {
		messages.add(message);
	}
}	
