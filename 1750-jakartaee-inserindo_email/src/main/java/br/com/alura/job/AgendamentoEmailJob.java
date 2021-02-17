package br.com.alura.job;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

@Singleton
public class AgendamentoEmailJob {

	@Inject
	private AgendamentoEmailServico service;
	
	@Schedule(hour = "*", minute = "*", second = "*/10")
	public synchronized void enviarEmail() { 
		List<AgendamentoEmail> naoAgendados = service.naoAgendados();
		naoAgendados.forEach(email -> {
			service.enviar(email);
			service.alterar(email);
		});
	}
}
