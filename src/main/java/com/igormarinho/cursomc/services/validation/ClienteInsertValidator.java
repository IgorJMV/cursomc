package com.igormarinho.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.igormarinho.cursomc.domain.enums.TipoCliente;
import com.igormarinho.cursomc.dto.ClienteNewDTO;
import com.igormarinho.cursomc.resources.exceptions.FieldMessage;
import com.igormarinho.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {}

	@Override
	public boolean isValid(ClienteNewDTO dto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(dto.getTipo().equals(TipoCliente.PESSOA_FISICA.getCod()) && !BR.isValidCPF(dto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}
		if(dto.getTipo().equals(TipoCliente.PESSOA_JURIDICA.getCod()) && !BR.isValidCPF(dto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
				   .addConstraintViolation();
		}
		return list.isEmpty();
	}
}
