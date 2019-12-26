package com.app.Service;



import java.util.Properties;

import javax.mail.*;
import javax.mail.Address;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMail {
	public static void sendTextmail(String mail,String name,int reg) {
		Properties props=new Properties();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port",465);
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.debug","true");
		props.put("mail.smtp.socketFactory.port",465);
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback","false");
		
		Session session =Session.getDefaultInstance(props, null);
		session.setDebug(true);
		MimeMessage message=new MimeMessage(session);
		try {
			message.setText(name+"You are registered successfully.Your Registration Number is "+reg);
			message.setSubject("DESTNY-REG");
			message.setFrom(new InternetAddress("jugalnagar0@gmail.com"));
			message.addRecipient(RecipientType.TO,new InternetAddress(mail) );
			message.saveChanges();
			Transport transport=session.getTransport("smtp");
			transport.connect("smtp.gmail.com", "jugalnagar0@gmail.com", "Jugnuu0@7213");
			transport.send(message, message.getAllRecipients());
			transport.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
