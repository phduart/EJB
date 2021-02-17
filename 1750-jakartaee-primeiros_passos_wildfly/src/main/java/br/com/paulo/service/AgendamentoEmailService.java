package br.com.paulo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.paulo.dao.AgendamentoEmailDao;
import br.com.paulo.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailService {
	
	@Inject
	private AgendamentoEmailDao dao;

	public List<AgendamentoEmail> listar(){
		return dao.listar();
	}
}
