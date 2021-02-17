package br.com.alura.servico;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.alura.dao.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailServico {
	
	private static final Logger LOGGER = 
			Logger.getLogger(AgendamentoEmailServico.class.getName());

	@Inject
	private AgendamentoEmailDAO dao;

	public List<AgendamentoEmail> listar() {
		return dao.listar();
	}
	
	public List<AgendamentoEmail> naoAgendados(){
		return dao.naoAgendados();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(false);
		dao.inserir(agendamentoEmail);
	}
	
	public void alterar(AgendamentoEmail email) {
		email.setAgendado(true);
		dao.alterar(email);
	}
	
	public void enviar(AgendamentoEmail email) {
		try {
			Thread.sleep(300);
			LOGGER.info("O email do " + email.getEmail() + " foi enviado!");
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
		}
	}
}
