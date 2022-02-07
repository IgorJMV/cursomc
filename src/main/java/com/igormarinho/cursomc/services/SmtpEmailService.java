package com.igormarinho.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import lombok.extern.java.Log;

@Log
public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		log.info("Enviando de email...");
		mailSender.send(msg);
		log.info("Email enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		log.info("Enviando de email...");
		javaMailSender.send(msg);
		log.info("Email enviado");
	}

}
