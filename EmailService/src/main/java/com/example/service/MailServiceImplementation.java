package com.example.service;

import com.example.dto.ResponseDTO;
import com.example.util.StringList;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class MailServiceImplementation implements MailService {

    private final JavaMailSender mailSender;
    @Override
    public ResponseDTO send(String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(email);
            helper.setSubject("Fashion Gallery");
            helper.setFrom("dinukaekanayaka18@gmail.com");

            String content = "Hey "+"Dinuka"+" "+",<br><br>"
                + "Please get below code to verify your registration:<br>"
                + "Device: Chrome on Windows"
                + "<h3>verification code : "+"</h3>"
                + "Thank you,<br>"
                + "Microservices application";

            helper.setText(content,true);
            mailSender.send(mimeMessage);
            return ResponseDTO.builder()
                    .code(StringList.RSP_SUCCESS)
                    .message("Email Sent")
                    .build();

        } catch (MessagingException e) {
            return ResponseDTO.builder()
                    .code(StringList.RSP_ERROR)
                    .message("failed to send email")
                    .build();
        }
    }

}
