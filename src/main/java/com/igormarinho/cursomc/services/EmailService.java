package com.igormarinho.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.igormarinho.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
