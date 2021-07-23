package completed.projects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BulkEmail {
	static String subject, name, message, line;
	public static void main(String[] args) throws Exception {
		
		List<String> address= new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader("EmailAddresses.txt"));
		while ((line = reader.readLine()) != null) {
		    address.add(line);
		}
		reader.close();
		
		ListIterator<String> li=address.listIterator();
		while(li.hasNext()) {
			String ad=li.next();
			int index =ad.indexOf('@'); 
			name = ad.substring(0,index);
			content(name);
			sendBulkEmail(subject, ad, message);
		}
		System.out.println("Your emails sent successfully....");
	}
	
	public static void content(String name1) {
			subject=" GitHub Details ";
			message="Dear "+name1+","+"\n\nGreetings to you. \n\nWelcome to my GitHub Account, \nGitHub URL:- https://github.com/Sam1128/HIT \n\nThanks & Regards \nMs.Samiksha";
		}
		
	public static void sendBulkEmail(final String subject, final String ad, final String message) {

			final String username = "samchodankar1128@gmail.com";
			final String password = "zkukyyvvygxenqrm";
			String smtpHost = "smtp.gmail.com";

			Properties props = new Properties();
			
			props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", smtpHost);
		    props.put("mail.smtp.port", "587");
		      
		      
		    Session session = Session.getInstance(props,
		 	         new javax.mail.Authenticator() {
		 	            protected PasswordAuthentication getPasswordAuthentication() {
		 	               return new PasswordAuthentication(username, password);
		 		   }
		 	         });

		     try {
		 		   Message msg = new MimeMessage(session);
		 		   msg.setFrom(new InternetAddress(username));
		 		   msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(ad));
		 		   msg.setSubject(subject);
		 		   msg.setText(message);
		 		   Transport.send(msg);		 		   
		 	     
		    }catch (MessagingException exp) {
		 	         throw new RuntimeException(exp);
		 	      }
		 	   }
}
