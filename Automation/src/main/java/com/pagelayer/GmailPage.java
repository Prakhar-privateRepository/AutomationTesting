package com.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPage extends BasePage {

	private static final GmailPage getInstance = new GmailPage();

	public ThreadLocal<WebDriver> driver;

	@FindBy(xpath = "//*[contains(@aria-label,'Gmail')]")
	private WebElement gmailbutton;

	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement signinbutton;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailorphoneTextField;

	@FindBy(xpath = "//span[text()='Next']//parent::button")
	private WebElement nextbutton;

	@FindBy(xpath = "//span[text()='Continue']//parent::button")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement enteryourpasswordTextField;

	@FindBy(xpath = "//div[text()='Compose']")
	private WebElement composebutton;

	@FindBy(xpath = "//div[text()='Recipients']")
	private WebElement recipientsTextField;

	@FindBy(xpath = "//span[contains(@aria-label, 'Add Cc recipients')]")
	private WebElement ccbutton;

	@FindBy(xpath = "//input[contains(@aria-label, 'CC recipients')]")
	private WebElement ccTextField;

	@FindBy(xpath = "//span[contains(@aria-label, 'Add Bcc recipients')]")
	private WebElement bccbutton;

	@FindBy(xpath = "//input[contains(@aria-label, 'BCC recipients')]")
	private WebElement bccTextField;

	@FindBy(xpath = "//input[@name='subjectbox']")
	private WebElement subjectTextField;

	@FindBy(xpath = "//div[@aria-label='Message Body']")
	private WebElement body;

	@FindBy(xpath = "//div[text()='Send']")
	private WebElement sendbutton;

	@FindBy(xpath = "//span[text()='New Message']")
	private WebElement newmassageText;

	@FindBy(xpath = "//span[text()='Message sent']")
	private WebElement messagesentText;

	private GmailPage() {
	}

	public static GmailPage getInstance() {
		return getInstance;
	}

	public GmailPage(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
		PageFactory.initElements(driver.get(), this);
	}

	public void enterLoginGmail(String email) {

		emailorphoneTextField.sendKeys(email);
	}

	public void enterLoginPassword(String password) {

		enteryourpasswordTextField.sendKeys(password);
	}

	public void clicksOnNextButton() {
		nextbutton.click();
	}

	public void clicksOnContinueButton() {
		continueButton.click();
	}

	public void clicksOnGmailButton() {
		gmailbutton.click();
	}

	public void clicksOnComposeButton() {
		composebutton.click();
	}

	public String captureNewMessageText() {
		return BasePage.getText(newmassageText);
	}

	public void clicksOnRecipientsTextField() {
		recipientsTextField.click();
	}

	public void writeToEmail(String toEmail) {
		recipientsTextField.sendKeys(toEmail);
	}

	public void clicksOnCCButton() {
		ccbutton.click();
	}

	public void writeCCEmail(String ccEmail) {
		ccTextField.sendKeys(ccEmail);
	}

	public void clicksOnBCCButton() {
		bccbutton.click();
	}

	public void writeBCCEmail(String bccEmail) {
		bccTextField.sendKeys(bccEmail);
	}

	public void writeSubject(String subject) {
		subjectTextField.sendKeys(subject);
	}

	public void writeBody(String bodyText) {
		body.sendKeys(bodyText);
	}

	public void clicksOnSendButton() {
		sendbutton.click();
	}

	public String capturemessagesentText() {
		return BasePage.getText(messagesentText);
	}
}
