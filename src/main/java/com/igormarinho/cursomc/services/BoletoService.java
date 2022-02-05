package com.igormarinho.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import com.igormarinho.cursomc.domain.PagamentoComBoleto;

public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instant) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instant);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}

}
