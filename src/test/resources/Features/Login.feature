#Author: your.email@your.domain.com

Feature: Chat Monitoring

	@smoke
  Scenario Outline: Verifying the O2 Chat Monitoring System
    #Given User Launch Browser
    Given User Launch Browser and opens URL "https://www.o2online.de/chat-auswahl"
    When User clicks on link O2 Service live chat
    #Then Update the Url "https://www.o2online.de/chat-ui/chat.html?cg=bk&sn=CCT_C_MONITOR"
 		And click LoginButton
    And User enters username as "4917661590911" and password as "o2-FreeS-CCT-141076"
    #And Click on Login
    Then start the chat <ChatMsg>
    And Get Chat History
    Then End the Chat
    And close the browser
    
    Examples:
    | ChatMsg |
    | "Hi" |
        

