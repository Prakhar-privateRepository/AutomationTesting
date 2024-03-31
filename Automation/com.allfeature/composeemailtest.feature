Feature: Test Compose Functionality of GMAIL Application

  @logingmail
  Scenario: User launches browser and logged into gmail
    Given User lanch "chrome" browser and user loaded gmail with url "https://mail.google.com/mail/"
    #pleaes specify email
    When User enter email as ""
    When User clicks on next button where text is "Next"
    #pleaes spacify password
    When User enter password as ""
    When User clicks on next button where text is "Next"
    When User clicks on continue button

  @sendcomposeemail
  Scenario: User compose email and sendemail
    Given User on gmail page
    When User clicks on compose button
    Then A Popup box will open with New Message where text is "New Message"
    When User clicks on Recipients text field
    #pleaes specify to email
    When User enter email to To field as ""
    When User clicks on Cc button
    #pleaes specify cc email
    When User enter email to Cc Field as ""
    When User clicks on Bcc button
    #pleaes specify bcc email
    When User clicks enter email to Bcc field as ""
    When User enter subject as ""
    When User enter email body as ""
    When User clicks on send button  
    Then User get message "Message sent"