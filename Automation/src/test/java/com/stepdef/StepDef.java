package com.stepdef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.corelayer.CoreClass;
import com.pagelayer.BasePage;
import com.pagelayer.GmailPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends CoreClass {

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@Given("User lanch {string} browser and user loaded gmail with url {string}")
	public void user_lanch_browser_and_user_loaded_gmail_with_url(String string, String string2) {
		CoreClass.initialization();
		BasePage.loadUrl(string2);
	}

	@When("User enter email as {string}")
	public void user_enter_email_as(String string) {
		GmailPage.getInstance().enterLoginGmail(string);
	}

	@When("User clicks on next button where text is {string}")
	public void user_clicks_on_next_button_where_text_is(String string) {
		GmailPage.getInstance().clicksOnNextButton();
	}

	@When("User enter password as {string}")
	public void user_enter_password_as(String string) {
		GmailPage.getInstance().enterLoginPassword(string);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		GmailPage.getInstance();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		GmailPage.getInstance().clicksOnContinueButton();
	}

	@Given("User on gmail page")
	public void user_on_gmail_page() {
		Assert.assertTrue(BasePage.getCurrentUrl().contains("inbox"));
	}

	@When("User clicks on compose button")
	public void user_clicks_on_compose_button() {
		GmailPage.getInstance().clicksOnComposeButton();
	}

	@Then("A Popup box will open with New Message where text is {string}")
	public void a_popup_box_will_open_with_new_message_where_text_is(String string) {
		Assert.assertTrue(GmailPage.getInstance().captureNewMessageText().contains(string));
	}

	@When("User clicks on Recipients text field")
	public void user_clicks_on_recipients_text_field() {
		GmailPage.getInstance().clicksOnRecipientsTextField();
	}

	@When("User enter email to To field as {string}")
	public void user_enter_email_to_to_field_as(String string) {
		GmailPage.getInstance().writeToEmail(string);
	}

	@When("User clicks on Cc button")
	public void user_clicks_on_cc_button() {
		GmailPage.getInstance().clicksOnCCButton();
	}

	@When("User enter email to Cc Field as {string}")
	public void user_enter_email_to_cc_field_as(String string) {
		GmailPage.getInstance().writeCCEmail(string);
	}

	@When("User clicks on Bcc button")
	public void user_clicks_on_bcc_button() {
		GmailPage.getInstance().clicksOnBCCButton();
	}

	@When("User clicks enter email to Bcc field as {string}")
	public void user_clicks_enter_email_to_bcc_field_as(String string) {
		GmailPage.getInstance().writeBCCEmail(string);
	}

	@When("User enter subject as {string}")
	public void user_enter_subject_as(String string) {
		GmailPage.getInstance().writeSubject(string);
	}

	@When("User enter email body as {string}")
	public void user_enter_email_body_as(String string) {
		GmailPage.getInstance().writeBody(string);
	}

	@When("User clicks on send button")
	public void user_clicks_on_send_button() {
		GmailPage.getInstance().clicksOnSendButton();
	}

	@Then("User get message {string}")
	public void user_get_message(String string) {
		Assert.assertTrue(GmailPage.getInstance().capturemessagesentText().contains(string));
	}
}
