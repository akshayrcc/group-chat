package com.udacity.mvc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.udacity.mvc.model.ChatMessage;

public class ChatPage {

	@FindBy(id="username")
    private WebElement username;
	
    @FindBy(id="messageText")
    private WebElement textField;

    @FindBy(id="submitMessage")
    private WebElement submitButton;

//    @FindBy(className = "chatMessageUsername")
//    private WebElement firstMessageUsername;
//
//    @FindBy(className = "chatMessageText")
//    private WebElement firstMessageText;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendChatMessage(String username,String text) {
    	this.username.sendKeys(username);
        this.textField.sendKeys(text);
        this.submitButton.click();
    }

    public ChatMessage getFirstMessage() {
        ChatMessage result = new ChatMessage();
        result.setMessage(username.getText(),textField.getText());
        return result;
    }

}