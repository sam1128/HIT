package teamProjects;

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

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
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

public class ECertificate {

	public static void main(String[] args) throws Exception {
		String name, ad, line;
		ECertificate cp = new ECertificate();
		List<String> details = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader("CertificateDetails.txt"));
		while ((line = reader.readLine()) != null) {
			details.add(line);
		}
		reader.close();

		ListIterator<String> li = details.listIterator();
		while (li.hasNext()) {
			String info = li.next();
			int indexName = info.indexOf(',');
			name = info.substring(indexName + 2);
			ad = info.substring(0, indexName);
			cp.CreatePdf(name);
			cp.sendEmail(ad, name);
		}
		System.out.println("pdf E-certificate is generated and send Successfully...");
	}

	public void CreatePdf(String name) throws Exception {
		PdfReader reader = new PdfReader("Sample.pdf");
		PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(name + ".pdf"));
		Image img1 = Image.getInstance("D:/HIT course/workspace/HIT Projects/certificate.jpg");
		PdfContentByte c = stamp.getUnderContent(1);
		img1.setAbsolutePosition(0, 0);
		img1.scaleToFit(PageSize.A3.getWidth(), PageSize.A3.getHeight());
		c.addImage(img1);

		BaseFont bold = BaseFont.createFont(BaseFont.HELVETICA_OBLIQUE, BaseFont.WINANSI, BaseFont.EMBEDDED);

		TextField txt = new TextField(stamp.getWriter(), new Rectangle(750, 350, 100, 390), "newtxt");
		txt.setOptions(TextField.READ_ONLY);
		txt.setAlignment(Element.ALIGN_CENTER);
		txt.setTextColor(BaseColor.BLACK);
		txt.setFont(bold);
		txt.setFontSize(30);
		txt.setText(name);
		stamp.addAnnotation(txt.getTextField(), 1);

		TextField sig = new TextField(stamp.getWriter(), new Rectangle(910, 210, 240, 290), "signature");
		sig.setOptions(TextField.READ_ONLY);
		sig.setAlignment(Element.ALIGN_CENTER);
		sig.setTextColor(BaseColor.BLACK);
		sig.setFont(bold);
		sig.setFontSize(15);
		sig.setText("Ms.Samiksha");
		stamp.addAnnotation(sig.getTextField(), 1);

		TextField datetxt = new TextField(stamp.getWriter(), new Rectangle(350, 210, 180, 290), "date");
		datetxt.setOptions(TextField.READ_ONLY);
		datetxt.setAlignment(Element.ALIGN_CENTER);
		datetxt.setTextColor(BaseColor.BLACK);
		datetxt.setFont(bold);
		datetxt.setFontSize(15);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		datetxt.setText(LocalDate.now().format(format).toString());
		stamp.addAnnotation(datetxt.getTextField(), 1);

		stamp.close();
		reader.close();
		// f.close();
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

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(username));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adress));
			msg.setSubject("E-certificate of Appriciation");
			String filename = name + ".pdf";// change accordingly
			DataSource source = new FileDataSource(filename);
			msg.setDataHandler(new DataHandler(source));
			msg.setFileName(filename);
			Transport.send(msg);

		} catch (MessagingException exp) {
			throw new RuntimeException(exp);
		}
	}
}