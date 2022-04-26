package mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class AWSMailer {
    // This address must be verified.
    static final int MAX_ATTEMPTS = 3;
    static final String FROM = "noreply@zeuslearning.com";
    static final String FROMNAME = "noreply";

    // Replace smtp_username with your Amazon SES SMTP user name.
    static final String SMTP_USERNAME = "AKIAIPK4HJEQ5GGDQCOA";

    // Replace smtp_password with your Amazon SES SMTP password.
    static final String SMTP_PASSWORD = "Ap9dzD36qebxL3KnaxyOQDDFU9+dOVUO7JtbxNYqoqz9";

    // See
    // https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
    // for more information.
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";

    // The port you will connect to on the Amazon SES SMTP endpoint.
    static final int PORT = 587;

    public static void sendMail(String receipientStr, String subject, String body)
            throws MessagingException, UnsupportedEncodingException {

    	String[] arrRecipients = receipientStr.split(",");
        // Create a Properties object to contain connection configuration information.
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", AWSMailer.PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified
        // properties.
        Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(AWSMailer.FROM, AWSMailer.FROMNAME));
        for(String recipient : arrRecipients) {
        	msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient.trim()));
        }
        msg.setSubject(subject);

        // Create the message part
        BodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();

        messageBodyPart.setContent(body, "text/html");
        multipart.addBodyPart(messageBodyPart);

        msg.setContent(multipart);

        for (int attempt = 1; attempt <= AWSMailer.MAX_ATTEMPTS; attempt++) {
            // Create a transport.
            Transport transport = session.getTransport();
            try {
                System.out.println(
                        "Attempt " + attempt + " of " + AWSMailer.MAX_ATTEMPTS + " | Sending exception reports...");

                // Connect to Amazon SES using the SMTP username and password you specified
                // above.
                transport.connect(AWSMailer.HOST, AWSMailer.PORT, AWSMailer.SMTP_USERNAME, AWSMailer.SMTP_PASSWORD);

                // Send the email.
                transport.sendMessage(msg, msg.getAllRecipients());
                System.out.println("Email sent to " + receipientStr);
                break;
            } catch (Exception ex) {
                System.out.println("The email was not sent!");
                System.out.println("Error message: " + ex.getMessage());
            } finally {
                // Close and terminate the connection.
                transport.close();
            }
        }
    }
}
