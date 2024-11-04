package EmailFunctionality;

import java.io.*;
import java.security.SecureRandom;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtil {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CODE_LENGTH = 6;
    
    private static final String FROM_EMAIL = "testgeneratorappclass@gmail.com";
    private static final String EMAIL_PASSWORD = "nairalqsqcrexnbz";
    private static final String COMPANY_NAME = "Javaneers On a Mission";
    private static final String LOGO_PATH = "https://i.ibb.co/gw2JQ8g/logo-1-1.png/";
    public static String generateVerificationCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
    
    private static String createHtmlContent(String code) throws IOException {
        // Using table-based layout for better email client compatibility
        return "<!DOCTYPE html>"
             + "<html lang=\"en\">"
             + "<head>"
             + "<meta charset=\"UTF-8\">"
             + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
             + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
             + "<!--[if !mso]><!-->"
             + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
             + "<!--<![endif]-->"
             + "<style type=\"text/css\">"
             + "@media screen and (max-width: 600px) {"
             + "    .mobile-hidden { display: none !important; }"
             + "    .responsive-table { width: 100% !important; }"
             + "    .responsive-image { width: 150px !important; height: auto !important; }"
             + "    .mobile-text { font-size: 16px !important; }"
             + "}"
             + "</style>"
             + "</head>"
             + "<body style=\"margin: 0; padding: 0; background-color: #f9f9f9; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;\">"
             + "<!--[if mso]>"
             + "<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"#f9f9f9\"><tr><td>"
             + "<![endif]-->"
             + "<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; border-spacing: 0; border-collapse: collapse;\">"
             + "<tr>"
             + "<td align=\"center\" style=\"padding: 20px 0; background-color: #f8f9fa;\">"
             + "<img src='" + LOGO_PATH + "' alt='" + COMPANY_NAME + " Logo' class=\"responsive-image\" style=\"width: 200px; max-width: 100%; height: auto; display: block; border: 0;\" width=\"200\">"
             + "</td>"
             + "</tr>"
             + "<tr>"
             + "<td style=\"padding: 30px 20px;\">"
             + "<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"
             + "<tr>"
             + "<td style=\"padding-bottom: 20px; text-align: center;\">"
             + "<h2 style=\"margin: 0; color: #333333; font-family: Arial, sans-serif; font-size: 24px; line-height: 30px;\">Reset Password</h2>"
             + "</td>"
             + "</tr>"
             + "<tr>"
             + "<td style=\"padding-bottom: 20px;\">"
             + "<p style=\"margin: 0; color: #555555; font-family: Arial, sans-serif; font-size: 16px; line-height: 24px;\">Thank you for choosing " + COMPANY_NAME + ". To complete your verification process, please use the following code:</p>"
             + "</td>"
             + "</tr>"
             + "<tr>"
             + "<td style=\"padding: 15px; background-color: #f4f4f4; text-align: center;\">"
             + "<span style=\"font-family: 'Courier New', Courier, monospace; font-size: 24px; letter-spacing: 5px; font-weight: bold; color: #333333;\">" + code + "</span>"
             + "</td>"
             + "</tr>"
             + "<tr>"
             + "<td style=\"padding-top: 20px;\">"
             + "<p style=\"margin: 0; padding-bottom: 10px; color: #555555; font-family: Arial, sans-serif; font-size: 14px; line-height: 20px;\">This verification code will expire in 10 minutes for security purposes.</p>"
             + "<p style=\"margin: 0; padding-bottom: 20px; color: #555555; font-family: Arial, sans-serif; font-size: 14px; line-height: 20px;\">If you didn't request this verification code, please ignore this email or contact our support team if you have concerns.</p>"
             + "<p style=\"margin: 0; color: #555555; font-family: Arial, sans-serif; font-size: 14px; line-height: 20px;\">Best regards,<br>" + COMPANY_NAME + " Team</p>"
             + "</td>"
             + "</tr>"
             + "</table>"
             + "</td>"
             + "</tr>"
             + "<tr>"
             + "<td style=\"padding: 20px; text-align: center; border-top: 1px solid #eeeeee;\">"
             + "<p style=\"margin: 0; color: #666666; font-family: Arial, sans-serif; font-size: 12px; line-height: 18px;\">This is an automated message, please do not reply directly to this email.</p>"
             + "<p style=\"margin: 10px 0 0; color: #666666; font-family: Arial, sans-serif; font-size: 12px; line-height: 18px;\">&copy; " 
             + java.time.Year.now().getValue() + " " + COMPANY_NAME + ". All rights reserved.</p>"
             + "</td>"
             + "</tr>"
             + "</table>"
             + "<!--[if mso]>"
             + "</td></tr></table>"
             + "<![endif]-->"
             + "</body>"
             + "</html>";
    }
    
    public static void sendEmail(String to, String subject, String verificationCode) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, EMAIL_PASSWORD);
            }
        });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL, COMPANY_NAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            
            // Add additional headers for better client compatibility
            MimeMessage mimeMessage = (MimeMessage) message;
            mimeMessage.setHeader("Content-Type", "text/html; charset=UTF-8");
            mimeMessage.setHeader("Content-Transfer-Encoding", "quoted-printable");
            mimeMessage.setHeader("X-Mailer", "Microsoft Outlook");
            
            message.setContent(createHtmlContent(verificationCode), "text/html; charset=UTF-8");
            
            Transport.send(message);
            System.out.println("Code sent successfully!");
            
        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw new MessagingException("Failed to send email", e);
        }
    }
    // Test method
    /*public static void main(String[] args) {
        try {
            String code = generateVerificationCode();
            sendEmail("mohabkamle9@gmail.com",
                     COMPANY_NAME + " - Verification Code",
                     code);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }*/
}