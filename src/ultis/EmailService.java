package ultis;

import entity.FormEmail;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailService {

    public static void sendEmail(String to, FormEmail formEmail) throws Exception {
        String from = "namdinhnguyen1003@gmail.com";
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "namdinhnguyen1003@gmail.com";
        String emailPassword = "hjukwnamcskqfknt";

        // Create properties for the email session
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a new session with an authenticator
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, emailPassword);
            }
        };
        Session session = Session.getInstance(properties, authenticator);

        // Create a new email message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Báo Cáo Doanh Thu Trong Ngày");
        String emailContent = "Mã Nhân Viên: " + formEmail.getMa() + "\n"
                + "Tên Nhân Viên: " + formEmail.getHoTen() + "\n"
                + "Tổng Tiền: " + formEmail.getTongTien() + "\n"
                + "Nội Dung: " + formEmail.getNoiDung();

        message.setText(emailContent);

        // Send the email message
        Transport.send(message);
    }
}
