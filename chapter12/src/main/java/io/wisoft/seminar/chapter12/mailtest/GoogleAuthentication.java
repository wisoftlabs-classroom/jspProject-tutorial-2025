package io.wisoft.seminar.chapter12.mailtest;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
	PasswordAuthentication passAuth;
    
    public GoogleAuthentication(){
        passAuth = new PasswordAuthentication("userName", "password");
    }
 
    public PasswordAuthentication getPasswordAuthentication() {
        return passAuth;
    }
}
