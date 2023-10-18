package com.udacity.mvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.udacity.mvc.model.ChatMessage;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatApplicationTests {

	@LocalServerPort
	public int port;

	public static WebDriver driver;

	public String baseURL;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
		driver = null;
	}

	@BeforeEach
	public void beforeEach() {
		baseURL = "http://localhost:" + port;
	}

	@Test
	public void testUserSignupLoginAndSubmitMessage() {
		String username = "pzastoup";
		String password = "whatabadpassword";
		String messageText = "Hello!";
		String msgFinal = username.concat(": " + messageText);

		driver.get(baseURL + "/signup");

		SignupPage signupPage = new SignupPage(driver);
		signupPage.signup("Peter", "Zastoupil", username, password);

		driver.get(baseURL + "/login");

		LoginPage loginPage = new LoginPage(driver);
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		loginPage.login(username, password);

		driver.get(baseURL + "/chat");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		ChatPage chatPage = new ChatPage(driver);
		chatPage.sendChatMessage(username, messageText);

		ChatMessage sentMessage = chatPage.getFirstMessage();

		// assertEquals(username, sentMessage.getUsername());

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertEquals(msgFinal, sentMessage.getMessage());

	}

}