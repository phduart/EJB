package br.com.paulo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.paulo.entity.AgendamentoEmail;

public class AgendamentoEmailDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<AgendamentoEmail> listar(){
		return entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae",
				AgendamentoEmail.class).getResultList();
	}
}

