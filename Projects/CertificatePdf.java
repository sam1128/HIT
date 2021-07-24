package completed.projects;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.TextField;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CertificatePdf {

    public static void main(String[] args) throws Exception {
    	String name,ad;
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Enter name:-");
    	name=scan.nextLine();
    	System.out.println("enter email address:-");
    	ad=scan.nextLine();
    	scan.close();
    	CertificatePdf cp=new CertificatePdf();
    	cp.CreatePdf(name);
    	cp.sendEmail(ad,name);
    	System.out.println("pdf E-certificate is generated and send Successfully...");
    }
    
    public void CreatePdf(String name) throws Exception {
        PdfReader reader=new PdfReader("Doc1.pdf");
        PdfStamper stamp=new PdfStamper(reader, new FileOutputStream(name+".pdf"));
        Image img1 = Image.getInstance("certificate.jpg");
        PdfContentByte c=stamp.getUnderContent(1);
        img1.setAbsolutePosition(0,0);
        img1.scaleToFit(PageSize.A3.getWidth(),PageSize.A3.getHeight());
        c.addImage(img1);
       
        BaseFont bold = BaseFont.createFont(BaseFont.HELVETICA_OBLIQUE,BaseFont.WINANSI,BaseFont.EMBEDDED);
        
        TextField txt=new TextField(stamp.getWriter(), new Rectangle(750,350,100,390), "newtxt");
        txt.setOptions(TextField.READ_ONLY);
        txt.setAlignment(Element.ALIGN_CENTER);
        txt.setTextColor(BaseColor.BLACK);
        txt.setFont(bold);
        txt.setFontSize(30);
        txt.setText(name);
        stamp.addAnnotation(txt.getTextField(),1);
  
        stamp.close();
        reader.close();
    }
    
    public void sendEmail(String adress, String name) {
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
	 		   msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(adress));
	 		   msg.setSubject("E-certificate of Appriciation");
	 		   String filename = name+".pdf";//change accordingly  
	 		   DataSource source = new FileDataSource(filename);  
	 		   msg.setDataHandler(new DataHandler(source));  
	 		   msg.setFileName(filename);
	 		   Transport.send(msg);		 		   
	 	     
	    }catch (MessagingException exp) {
	 	         throw new RuntimeException(exp);
	 	      }
	 	   }
	}