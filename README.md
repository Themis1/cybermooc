# cybermooc

LINK: https://github.com/Themis1/cybermooc  
Directions to use the application:  
The application offers a way to add events, sign up for them and view all participants. This is all done without signing in. There is also the possibility to sign in and in a beautiful world the admin would be able to view the lists of participants to different events, and perhaps be able to remove events and participants. Other users signed in would be able to do stuff that they are authorized to do.  
  
If you download and set up the application, you might want to check out the following links:  
http://localhost:8080/login  
http://localhost:8080/events  
http://localhost:8080/accounts  
http://localhost:8080/done  
  
There was also the links:  
http://localhost:8080/form  
http://localhost:8080/list  
  
But they are not really needed anymore after adding the signing up to each event separately. There are some flaws in the app and everything doesn’t work as they are supposed to.  
  
  
## FLAW 1:  
### Injection:  
For example in ‘accounts’ and in ‘events’ there are text fields which might allow sql injection. The data that is inserted there is not particularly validated.
Also in ‘done’ there is a text field that runs javascript. This might also allow sql injection or other kinds of malicious inputs.
Injection occurs when untrusted data is sent to an interpreter as part of a command or a query. The malicious data can trick the interpreter into executing unintended commands or accessing data without proper authorization.  
### How to fix it:  
In ‘SignupEventController’, ‘EventController’ and ‘AccountController’ should a validating method be put into use. The data should be parameterized. There is an example of this in ‘SignupEventController’.  
Also additional validating methods could be given to the data, for example the length and suitable input of the data. For example commands like: validators.DataRequired(message=("the message about the required data")) and validators.Length(min=3, max=30, message=("the message data length").  
  
## FLAW 2:  
### Sensitive Data Exposure:  
Personal data should never be available to the public. Currently all the lists for event participants are visible for anyone. Also the list of accounts is visible, including individual account pages (if one figures out the link). If one wants, they will also be able to retrieve passwords and other data from the application.  
### How to fix it:  
For one, all the links should be encrypted (instead of “/accounts/1”). The links should also be protected by authorization in a way that a person cannot see the link if he / she is not correctly authorized. One could use a command like @login_required().
The application is built incorrectly since the lists are visible on public pages. The lists should be moved behind authorization.  
  
## FLAW 3:  
### Broken Authentication:  
Attackers have access to hundreds of millions of valid username and password combinations for credential stuffing and default administrative account lists. Passwords should be encrypted and no default administrative accounts should be used. In this application passwords are not encrypted and if the users own account page is found, his / her password is straight up visible there. Also a default admin account is created when the application is started for the first time.  
### How to fix it:  
A simple java encryption is easy to apply, which will encrypt both the user passwords and the admin passwords. There is a code in the app ready for this. The method needed is BCryptPasswordEncoder().   
Passwords should not be visible in any circumstances. So listing of passwords should be taken out.  
  
## FLAW 4:  
### Security Misconfiguration:  
An application is vulnerable if for example the permissions are improperly configured, default accounts and their passwords are still enabled and unchanged, or security settings are not set to secure values. This applications still has default accounts. They were handled in the previous section.  
In addition, in ‘SecurityConfiguration’ the method ‘http.csrf().disable()’ is on. Also the authorizeRequests() might not be set properly.  
### How to fix it:  
To get things started, the ‘http.csrf().disable()’ should be taken off. In addition the ‘authorizeRequests()’ should be checked to fulfill the needs of the application. For example the accounts and h2-console should not be permitted to everyone, so those lines should be taken of or written differently. Additional authorization should be planned taken into consideration who need and are authorized to use the personal data added to the application.  
  
## FLAW 5:  
### Insufficient Logging & Monitoring:  
No logging or monitoring is performed in this application. Logging should be used both for monitoring the outside use of the application and for example penetration testing. Logging while testing the application is highly valuable, but one cannot forget the logging for all the events in the application.  
### How to fix it:  
All tasks possible to perform in the application should be done by only authorized  users. This way logging could be possible to perform effectively. Each task performed in the app should be saved in a log repository and the person (if known) should be saved as well. Each log should contain timestamp also.  

