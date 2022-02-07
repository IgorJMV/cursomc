package com.igormarinho.cursomc.services;

import javax.mail.internet.MimeMessage;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import lombok.extern.java.Log;

@Log
public class MockEmailService extends AbstractEmailService {

//	private static final Logger log = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		log.info("Simulando envio de email...");
		log.info(msg.toString());
		log.info("Email enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		log.info("Simulando envio de email html...");
		log.info(msg.toString());
		log.info("Email enviado");
	}

}
