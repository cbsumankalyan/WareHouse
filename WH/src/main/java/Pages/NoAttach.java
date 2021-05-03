package Pages;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class NoAttach extends SuperTestNG {

	public static void Sendmail() throws Exception {
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("unicitytechindia@gmail.com",
						"wrureljwqawaeysu");
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("unicitytechindia@gmail.com"));
		message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("in-web-bangalore@unicity.com"));

		

		String msg = "<p>Hello Team,<br> <br>"
				+ "please click on the below link to check the <strong>WareHouse</strong> Automation Suite <strong>Report.</strong>"
				+ "</p>http://10.2.0.23/WHReport/WareHouse"+date.format(timestamp)+".html"
				+ "<br><br>Thanks<br />" + "Unicity QA Team";
		
		message.setSubject("WareHouse Application Automation Report");

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		message.setContent(multipart);

		Transport.send(message);
		System.out.println("=====No Attachment Email Sent=====");
	}
}
